package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T03TransHis;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T03_TRANS_HIS照会
 *
 * @author emarfkrow
 */
public class T03TransHisGetAction extends BaseAction {

    /** T03_TRANS_HIS照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("T03TransHis.transId");
        }
        if (transId == null) {
            isAllKey = false;
        }

        Object transBn = postJson.get("transBn");
        if (transBn == null) {
            transBn = postJson.get("T03TransHis.transBn");
        }
        if (transBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T03TransHis t03TransHis = T03TransHis.get(transId, transBn);
            map.put("T03TransHis", t03TransHis);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
