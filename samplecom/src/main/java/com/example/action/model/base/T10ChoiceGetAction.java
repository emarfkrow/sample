package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Choice;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T10_CHOICE照会
 *
 * @author emarfkrow
 */
public class T10ChoiceGetAction extends BaseAction {

    /** T10_CHOICE照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object choiceId = postJson.get("choiceId");
        if (choiceId == null) {
            choiceId = postJson.get("T10Choice.choiceId");
        }
        if (choiceId == null) {

            T10Choice t10Choice = new T10Choice();

            // 選抜先になる場合は選抜元から情報をコピー
            Object koho1Id1 = postJson.get("koho1Id");
            if (koho1Id1 == null) {
                koho1Id1 = postJson.get("T10Choice.koho1Id");
            }
            if (koho1Id1 != null) {
                com.example.entity.T10Koho1 t10Koho1 = com.example.entity.T10Koho1.get(koho1Id1);
                t10Choice.setKoho1Id(t10Koho1.getKoho1Id());
                t10Choice.setKoho1Info(t10Koho1.getKoho1Info());
            }

            // 選抜先になる場合は選抜元から情報をコピー
            Object koho2Id2 = postJson.get("koho2Id");
            if (koho2Id2 == null) {
                koho2Id2 = postJson.get("T10Choice.koho2Id");
            }
            if (koho2Id2 != null) {
                com.example.entity.T10Koho2 t10Koho2 = com.example.entity.T10Koho2.get(koho2Id2);
                t10Choice.setKoho2Id(t10Koho2.getKoho2Id());
                t10Choice.setKoho2Info(t10Koho2.getKoho2Info());
            }

            map.put("T10Choice", t10Choice);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T10Choice t10Choice = T10Choice.get(choiceId);
            map.put("T10Choice", t10Choice);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
