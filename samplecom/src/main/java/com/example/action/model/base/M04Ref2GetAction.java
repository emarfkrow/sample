package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Ref2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M04_REF2照会
 *
 * @author emarfkrow
 */
public class M04Ref2GetAction extends BaseAction {

    /** M04_REF2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref2Id = form.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = form.get("M04Ref2.ref2Id");
        }
        if (ref2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M04Ref2 m04Ref2 = M04Ref2.get(ref2Id);
            map.put("M04Ref2", m04Ref2);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
