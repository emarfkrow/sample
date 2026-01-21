package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Choice;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 選抜照会
 *
 * @author emarfkrow
 */
public class Tb8ChoiceGetAction extends BaseAction {

    /** 選抜照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object choiceId = postJson.get("choiceId");
        if (choiceId == null) {
            choiceId = postJson.get("Tb8Choice.choiceId");
        }
        if (choiceId == null) {

            Tb8Choice tb8Choice = new Tb8Choice();

            // 選抜先になる場合は選抜元から情報をコピー
            Object sumId1 = postJson.get("sumId");
            if (sumId1 == null) {
                sumId1 = postJson.get("Tb8Choice.sumId");
            }
            if (sumId1 != null) {
                com.example.entity.Tb7Sum tb7Sum = com.example.entity.Tb7Sum.get(sumId1);
                tb8Choice.setSumId(tb7Sum.getSumId());
                tb8Choice.setSumInfo(tb7Sum.getSumInfo());
            }

            // 選抜先になる場合は選抜元から情報をコピー
            Object sum2Id2 = postJson.get("sum2Id");
            if (sum2Id2 == null) {
                sum2Id2 = postJson.get("Tb8Choice.sum2Id");
            }
            if (sum2Id2 != null) {
                com.example.entity.Tb8Sum2 tb8Sum2 = com.example.entity.Tb8Sum2.get(sum2Id2);
                tb8Choice.setSum2Id(tb8Sum2.getSum2Id());
                tb8Choice.setSum2Info(tb8Sum2.getSum2Info());
            }

            // 選抜先になる場合は選抜元から情報をコピー
            Object sum3Id3 = postJson.get("sum3Id");
            if (sum3Id3 == null) {
                sum3Id3 = postJson.get("Tb8Choice.sum3Id");
            }
            if (sum3Id3 != null) {
                com.example.entity.Tb8Sum3 tb8Sum3 = com.example.entity.Tb8Sum3.get(sum3Id3);
                tb8Choice.setSum3Id(tb8Sum3.getSum3Id());
                tb8Choice.setSum3Info(tb8Sum3.getSum3Info());
            }

            map.put("Tb8Choice", tb8Choice);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Choice tb8Choice = Tb8Choice.get(choiceId);
            map.put("Tb8Choice", tb8Choice);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
