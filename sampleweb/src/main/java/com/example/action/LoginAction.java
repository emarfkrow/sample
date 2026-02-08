package com.example.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;
import com.example.entity.MhrUser;
import com.example.entity.MhrUserPos;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.golorp.emarf.action.base.LoginActionBase;
import jp.co.golorp.emarf.form.LoginForm;
import jp.co.golorp.emarf.servlet.http.ServletUtil;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.time.DateTimeUtil;

/**
 * ログイン処理実装
 * @author toshiyuki
 *
 */
public class LoginAction extends LoginActionBase {

    @Override
    protected final LoginForm getLoginForm(final String userId) {

        LoginForm loginForm = null;

        //現在有効なユーザマスタ取得
        String mUserSql = this.loadSqlFile("MhrUserSearch");
        Map<String, Object> mUserParam = new HashMap<String, Object>();
        mUserParam.put("userId", userId);
        mUserParam.put("kaishiYmd2", DateTimeUtil.format("yyyy-MM-dd"));
        mUserParam.put("shuryoYmd1", DateTimeUtil.format("yyyy-MM-dd"));
        MhrUser mUser = Queries.get(mUserSql, mUserParam, MhrUser.class);

        if (mUser != null) {

            loginForm = new LoginForm();

            //パスワード
            loginForm.setPasswd(mUser.getPassword());

            //ログイン名
            loginForm.setAuthnMei(mUser.getUserSei() + " " + mUser.getUserMei());

            ObjectMapper mapper = ServletUtil.getMapper();

            //認証情報
            @SuppressWarnings("unchecked")
            Map<String, String> authnInfo = mapper.convertValue(mUser, Map.class);
            loginForm.setAuthnInfo(authnInfo);

            /*
             * 認可情報
             */

            Map<String, String> authzInfo = new HashMap<String, String>();

            //現在有効な全ての所属情報を取得
            String mShozokuSql = this.loadSqlFile("MhrUserPosSearch");
            Map<String, Object> mShozokuParam = new HashMap<String, Object>();
            mShozokuParam.put("userId", userId);
            mShozokuParam.put("kaishiYmd2", DateTimeUtil.format("yyyy-MM-dd"));
            mShozokuParam.put("shuryoYmd1", DateTimeUtil.format("yyyy-MM-dd"));
            List<MhrUserPos> mShozokus = Queries.select(mShozokuSql, mShozokuParam, MhrUserPos.class, null, null);

            //所属情報でループ
            if (mShozokus != null) {
                for (MhrUserPos mShozoku : mShozokus) {

                    //全ての認可情報を取得
                    String mNinkaSql = this.loadSqlFile("MhrShokuiNinkaSearch");
                    Map<String, Object> mNinkaParam = new HashMap<String, Object>();
                    mNinkaParam.put("bushoId", mShozoku.getBushoId());
                    mNinkaParam.put("shokuiId", mShozoku.getShokuiId());
                    mNinkaParam.put("kaishiYmd2", DateTimeUtil.format("yyyy-MM-dd"));
                    mNinkaParam.put("shuryoYmd1", DateTimeUtil.format("yyyy-MM-dd"));
                    List<MhrShokuiNinka> mNinkas = Queries.select(mNinkaSql, mNinkaParam, MhrShokuiNinka.class, null,
                            null);

                    //認可情報でループ
                    if (mNinkas != null) {
                        for (MhrShokuiNinka mNinka : mNinkas) {

                            //機能ごとに、最大の権限を取得
                            if (!authzInfo.containsKey(mNinka.getKinoNm())) {
                                authzInfo.put(mNinka.getKinoNm(), mNinka.getKengenKb());
                            } else {
                                String orgKengenKb = authzInfo.get(mNinka.getKinoNm());
                                if (Integer.valueOf(orgKengenKb) < Integer.valueOf(mNinka.getKengenKb())) {
                                    authzInfo.put(mNinka.getKinoNm(), mNinka.getKengenKb());
                                }
                            }
                        }
                    }
                }
            }

            loginForm.setAuthzInfo(authzInfo);
        }

        return loginForm;
    }

}
