package com.local.cheat.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.local.cheat.model.User;

import lombok.Data;

@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class UserSession implements Serializable {

      private static final long serialVersionUID = 6334063099671792256L;

      private User user;

}
