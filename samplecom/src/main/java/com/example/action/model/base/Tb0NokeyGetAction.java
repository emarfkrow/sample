package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb0Nokey;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 主キーなし照会
 *
 * @author emarfkrow
 */
public class Tb0NokeyGetAction extends BaseAction {

    /** 主キーなし照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object colD = postJson.get("colD");
        if (colD == null) {
            colD = postJson.get("Tb0Nokey.colD");
        }
        if (colD == null) {
            isAllKey = false;
        }

        Object colE = postJson.get("colE");
        if (colE == null) {
            colE = postJson.get("Tb0Nokey.colE");
        }
        if (colE == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb0Nokey tb0Nokey = Tb0Nokey.get(colD, colE);
            map.put("Tb0Nokey", tb0Nokey);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
