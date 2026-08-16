package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Ref3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M04_REF3照会
 *
 * @author emarfkrow
 */
public class M04Ref3GetAction extends BaseAction {

    /** M04_REF3照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref3Id = postJson.get("ref3Id");
        if (ref3Id == null) {
            ref3Id = postJson.get("M04Ref3.ref3Id");
        }
        if (ref3Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M04Ref3 m04Ref3 = M04Ref3.get(ref3Id);
            map.put("M04Ref3", m04Ref3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
