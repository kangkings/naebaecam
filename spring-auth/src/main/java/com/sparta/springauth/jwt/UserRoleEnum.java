package com.sparta.springauth.jwt;

public enum UserRoleEnum {
    //()안에 값 넣으면 생성자에 전달하는 것
    //이 경우 이 Enum.USER를 사용하면 아래 상수 USER의 값이 생성자로 넘어와서 authority에 세팅됨
    //authority변수는 USER라는 이름의 Enum값이 실제 가지게 될 문자열 값
    USER(Authority.USER),  // 사용자 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한

    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
