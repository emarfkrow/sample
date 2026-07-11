package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Ref3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M05_REF3照会
 *
 * @author emarfkrow
 */
public class M05Ref3GetAction extends BaseAction {

    /** M05_REF3照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref3Id = postJson.get("ref3Id");
        if (ref3Id == null) {
            ref3Id = postJson.get("M05Ref3.ref3Id");
        }
        if (ref3Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M05Ref3 m05Ref3 = M05Ref3.get(ref3Id);
            map.put("M05Ref3", m05Ref3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
