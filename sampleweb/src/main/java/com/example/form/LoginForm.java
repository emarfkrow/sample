package com.example.form;

import java.util.LinkedHashSet;
import java.util.Set;

import jp.co.golorp.emarf.form.base.LoginFormBase;

/**
 * ログインフォーム
 */
public class LoginForm extends LoginFormBase {

    @Override
    public final String getAuthZ(final String requestURI) {

        Set<String> errorIds = new LinkedHashSet<String>();

        String[] requestURIs = requestURI.split("/");
        String pagePath = requestURIs[requestURIs.length - 1];
        String pageName = pagePath.replaceFirst("\\..+$", "");

        for (String k : this.getAuthzInfo().keySet()) {
            if (pageName.matches(k)) {
                Object v = this.getAuthzInfo().get(k);

                int authz = Integer.parseInt(v.toString());

                if ((authz & 0b00000001) == 0) {
                    errorIds.add("error.authz.view"); // 第１ビット：照会権限
                }
                if ((authz & 0b00000010) == 0) {
                    errorIds.add("error.authz.seek"); // 第２ビット：検索権限
                }
                if ((authz & 0b00000100) == 0) {
                    errorIds.add("error.authz.output"); // 第３ビット：出力権限
                }
                if ((authz & 0b00001000) == 0) {
                    errorIds.add("error.authz.anew"); // 第４ビット：追加権限
                }
                if ((authz & 0b00010000) == 0) {
                    errorIds.add("error.authz.edit"); // 第５ビット：更新権限
                }
                if ((authz & 0b00100000) == 0) {
                    errorIds.add("error.authz.delete"); // 第６ビット：削除権限
                }
                if ((authz & 0b01000000) == 0) {
                    errorIds.add("error.authz.permit"); // 第７ビット：承認権限
                }
                if ((authz & 0b10000000) == 0) {
                    errorIds.add("error.authz.forbid"); // 第８ビット：否認権限
                }
            }
        }

        return null;
    }

}
