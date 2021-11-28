package com.local.cheat.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserForm {
	
	@NotEmpty(message = "ユーザー名を入力してください。")
	@Size(min=3 ,max = 10, message = "ユーザー名は3~10文字で設定してください。")
	@Pattern(regexp="[a-zA-Z0-9__-]+", message="使用できる文字はローマ字、数字、ハイフン、アンダーバーのみです。")
    private String username;
	
	@NotEmpty(message = "パスワードを入力してください。")
	@Size(min=5 ,max = 20, message = "パスワードは5~20文字で設定してください。")
    private String password;
	
	@NotEmpty(message = "確認用パスワードを入力してください。")
	private String checkPassword;
    
    @AssertTrue(message="2つのパスワードが一致しません。")
    private boolean isValidPassword() {
        return password.equals(checkPassword);
    }
	
}
