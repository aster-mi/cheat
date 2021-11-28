package com.local.cheat.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ChangePasswordForm {

	private String oldPassword;
	
	@NotEmpty(message = "新パスワードを入力してください。")
	@Size(min=5 ,max = 20, message = "新パスワードは5~20文字で設定してください。")
	private String newPassword;
	
	private String checkNewPassword;
	
    @AssertTrue(message="2つのパスワードが一致しません。")
    private boolean isValidPassword() {
        return newPassword.equals(checkNewPassword);
    }
	
}
