package com.local.cheat.config;

import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class IFTTTAppendar extends AppenderBase<ILoggingEvent> {

	private SimpleDateFormat sdf = new SimpleDateFormat("GGGGy年 M月 d日 (E) a h時 m分 s秒");

	@Override
	protected void append(ILoggingEvent event) {
		if (Level.ERROR.equals(event.getLevel())) {
			var pro = event.getThrowableProxy();
			var events = pro.getStackTraceElementProxyArray();
			var head = sdf.format(new Date(event.getTimeStamp()));
			String msg = "[ERROR]" + head;
			System.out.println(msg);
			System.out.println(event);
			msg += " " + pro.getClassName() + " " + pro.getMessage();
			for (var e : events) {
				if (e.toString().contains(".cheat.")) {
					msg += " " + e.toString();
				}
				System.out.println(e);
			}
			// ダブルクオーテーションをシングルに変換
			msg = msg.replace('\"', '\'');
			// IFTTTに送信
			requestWeb("{ \"value1\" : \"" + msg + "\" }",
					"https://maker.ifttt.com/trigger/relearn_log/with/key/bYwkNDE9lWYKhFq2wRnatv");
		}
	}

	/**
	 * HTTPリクエストを送る
	 * 
	 * <pre>
	 * 指定されたURLへ、HTTPリクエストでJSONオブジェクトを送ります。
	 * </pre>
	 * 
	 * @param json : 送信電文（主文）
	 * @param url  ： 送信先URL
	 **/
	void requestWeb(String json, String url) {

		try {
			// 送信先URLを指定してHttpコネクションを作成する
			URL sendUrl = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) sendUrl.openConnection();

			// リクエストヘッダをセット
			con.addRequestProperty("Content-Type", "application/JSON; charset=utf-8");
			con.addRequestProperty("User-Agent", "DiscordBot");
			// URLを出力利用に指示
			con.setDoOutput(true);
			// 要求方法にはPOSTを指示
			con.setRequestMethod("POST");

			// 要求を送信する
			// POSTデータの長さを設定
			con.setRequestProperty("Content-Length", String.valueOf(json.length()));
			// リクエストのbodyにJSON文字列を書き込む
			OutputStream stream = con.getOutputStream();
			stream.write(json.getBytes("UTF-8"));
			stream.flush();
			stream.close();

			// HTTPレスポンスコード
			con.getResponseCode();

			// 後始末
			con.disconnect();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}