package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKbnVal;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 区分値マスタ照会
 *
 * @author emarfkrow
 */
public class MsyKbnValGetAction extends BaseAction {

    /** 区分値マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kbnNm = postJson.get("kbnNm");
        if (kbnNm == null) {
            kbnNm = postJson.get("MsyKbnVal.kbnNm");
        }
        if (kbnNm == null) {
            isAllKey = false;
        }

        Object kbnVal = postJson.get("kbnVal");
        if (kbnVal == null) {
            kbnVal = postJson.get("MsyKbnVal.kbnVal");
        }
        if (kbnVal == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.MsyKbn msyKbn = com.example.entity.MsyKbn.get(kbnNm);
        map.put("MsyKbn", msyKbn);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MsyKbnVal msyKbnVal = MsyKbnVal.get(kbnNm, kbnVal);
            map.put("MsyKbnVal", msyKbnVal);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
