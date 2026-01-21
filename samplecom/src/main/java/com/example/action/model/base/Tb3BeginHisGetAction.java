package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3BeginHis;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 履歴照会
 *
 * @author emarfkrow
 */
public class Tb3BeginHisGetAction extends BaseAction {

    /** 履歴照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object beginId = postJson.get("beginId");
        if (beginId == null) {
            beginId = postJson.get("Tb3BeginHis.beginId");
        }
        if (beginId == null) {
            isAllKey = false;
        }

        Object rirekiBn = postJson.get("rirekiBn");
        if (rirekiBn == null) {
            rirekiBn = postJson.get("Tb3BeginHis.rirekiBn");
        }
        if (rirekiBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb3BeginHis tb3BeginHis = Tb3BeginHis.get(beginId, rirekiBn);
            map.put("Tb3BeginHis", tb3BeginHis);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
