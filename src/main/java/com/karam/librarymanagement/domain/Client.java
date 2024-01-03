package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;
import com.karam.librarymanagement.domain.exception.InvalidValueException;

import java.util.regex.Pattern;

public class Client extends DomainValidation {

    private Long registration;
    private String name;
    private String email;
    private String password;
    private String cpf;

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{5,}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    private static final String CPF_REGEX =
            "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

    private static final Pattern CPF_PATTERN = Pattern.compile(CPF_REGEX);

    private Client(Long registration, String name, String email, String password, String cpf) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.validate();
    }

    private void validate() {
        if (this.isNull(name)) {
            throw new FieldIsRequiredException("Campo 'name' esta nulo");
        }

        if (this.isNull(email)) {
            throw new FieldIsRequiredException("Campo 'email' esta nulo");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidValueException("Estrutura do email esta invalido");
        }

        if (this.isNull(password)) {
            throw new FieldIsRequiredException("Campo 'password' esta nulo");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidValueException("A senha precisa ter no minimo 5 caracteres, incluindo no minimo 1 numero e 1 caracter especial");
        }

        if (this.isNull(cpf)) {
            throw new FieldIsRequiredException("Campo 'cpf' esta nulo");
        }

        if (!CPF_PATTERN.matcher(cpf).matches()) {
            throw new InvalidValueException("Estrutura do cpf esta invalido");
        }
    }

    public Long getRegistration() {
        return registration;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String cpf;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Client build() {
            return new Client(
                    this.id,
                    this.name,
                    this.email,
                    this.password,
                    this.cpf
            );
        }
    }
}
