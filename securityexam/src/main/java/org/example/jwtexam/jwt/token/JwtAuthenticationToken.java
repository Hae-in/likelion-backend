package org.example.jwtexam.jwt.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private Object principal; // 사용자 정보 (UserDetails)
    private Object credentials; // 인증 자격 증명 (보통 비밇번호가 들어감, JWT 기반에서는 null)

    // 인증이 완료된 후 호출되는 생성자
    public JwtAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal, Object credentials) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true); // 인증 완료 상태
    }

    // 인증 전 사용되는 생성자
    public JwtAuthenticationToken(String token) {
        super(null); // 권한 없는 상태
        this.principal = null; // 사용자 정보 없는 상태
        this.credentials = token;
        setAuthenticated(false); // 인증 전 상태
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
