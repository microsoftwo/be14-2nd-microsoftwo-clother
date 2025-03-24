package com.microsoftwo.clother.user.service;

import com.microsoftwo.clother.email.config.RedisUtil;
import com.microsoftwo.clother.email.exception.CustomException;
import com.microsoftwo.clother.security.vo.LoginResponseVO;
import com.microsoftwo.clother.user.aggregate.Role;
import com.microsoftwo.clother.user.aggregate.UserEntity;
import com.microsoftwo.clother.user.repository.UserRepository;
import com.microsoftwo.clother.user.vo.SignupRequestVO;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;
    private final RedisUtil redisUtil;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                           ModelMapper modelMapper, RedisUtil redisUtil) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
        this.redisUtil = redisUtil;
    }


    // 기능 : 회원가입
    @Override
    public String registerUser(@Valid SignupRequestVO signupRequestVO) throws CustomException {
        // 이메일 중복 체크
        Optional<UserEntity> existingUser = userRepository.findByEmailOrNickname(signupRequestVO.getEmail(),
                signupRequestVO.getNickname());
        if (existingUser.isPresent()) {
            log.error("회원가입 실패 - 이미 존재하는 닉네임: {}", signupRequestVO.getNickname());
            throw new CustomException("이미 존재하는 닉네임입니다.");
        }

        // 이메일 인증 여부 확인
        if (!redisUtil.exists(signupRequestVO.getEmail())) {
            log.error("회원가입 실패 - 이메일 인증 필요: {}", signupRequestVO.getEmail());
            throw new CustomException("이메일 인증을 먼저 진행해 주세요.");
        }

        log.info("회원가입 진행 - 이메일: {}, 닉네임: {}", signupRequestVO.getEmail(), signupRequestVO.getNickname());

        // 회원 저장 로직...
        // DTO → Entity 변환 / 엔티티의 password 컬럼에 암호화 된 값을 추가
        UserEntity newUser = modelMapper.map(signupRequestVO, UserEntity.class);
        newUser.setPassword(bCryptPasswordEncoder.encode(signupRequestVO.getPassword())); // 비밀번호 암호화
        newUser.setRole(Role.USER);

        userRepository.save(newUser);
        redisUtil.deleteData(signupRequestVO.getEmail());

        return "회원가입이 완료되었습니다.";
    }

    @Override
    public LoginResponseVO findMemberInfoById(Long userId) {
        return userRepository.findById(userId)
                .map(LoginResponseVO::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    @Override
    public LoginResponseVO findMemberInfoByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(LoginResponseVO::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    /* memo : login 할때 자동 호출될 메소드 */
    /* 설명. spring security 사용 시 프로바이더에서 활요할 로그인용 메소드(id로 회원 조회해서 UserDetails 타입을 반환하는 메소드) */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
