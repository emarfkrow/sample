package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive2Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_DERIVE2_DET照会
 *
 * @author emarfkrow
 */
public class T07Derive2DetGetAction extends BaseAction {

    /** T07_DERIVE2_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = form.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = form.get("T07Derive2Det.derive2Id");
        }
        if (derive2Id == null) {
            isAllKey = false;
        }

        Object derive2Bn = form.get("derive2Bn");
        if (derive2Bn == null) {
            derive2Bn = form.get("T07Derive2Det.derive2Bn");
        }
        if (derive2Bn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T07Derive2 t07Derive2 = com.example.entity.T07Derive2.get(derive2Id);
            map.put("T07Derive2", t07Derive2);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Derive2Det t07Derive2Det = T07Derive2Det.get(derive2Id, derive2Bn);
            map.put("T07Derive2Det", t07Derive2Det);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
