package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Choice;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T09_CHOICE照会
 *
 * @author emarfkrow
 */
public class T09ChoiceGetAction extends BaseAction {

    /** T09_CHOICE照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object choiceId = postJson.get("choiceId");
        if (choiceId == null) {
            choiceId = postJson.get("T09Choice.choiceId");
        }
        if (choiceId == null) {

            T09Choice t09Choice = new T09Choice();

            // 選抜先になる場合は選抜元から情報をコピー
            Object koho1Id1 = postJson.get("koho1Id");
            if (koho1Id1 == null) {
                koho1Id1 = postJson.get("T09Choice.koho1Id");
            }
            if (koho1Id1 != null) {
                com.example.entity.T09Koho1 t09Koho1 = com.example.entity.T09Koho1.get(koho1Id1);
                t09Choice.setKoho1Id(t09Koho1.getKoho1Id());
                t09Choice.setKoho1Info(t09Koho1.getKoho1Info());
            }

            // 選抜先になる場合は選抜元から情報をコピー
            Object koho2Id2 = postJson.get("koho2Id");
            if (koho2Id2 == null) {
                koho2Id2 = postJson.get("T09Choice.koho2Id");
            }
            if (koho2Id2 != null) {
                com.example.entity.T09Koho2 t09Koho2 = com.example.entity.T09Koho2.get(koho2Id2);
                t09Choice.setKoho2Id(t09Koho2.getKoho2Id());
                t09Choice.setKoho2Info(t09Koho2.getKoho2Info());
            }

            map.put("T09Choice", t09Choice);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T09Choice t09Choice = T09Choice.get(choiceId);
            map.put("T09Choice", t09Choice);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
