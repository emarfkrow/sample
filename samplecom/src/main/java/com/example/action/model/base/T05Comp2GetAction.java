package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T05Comp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T05_COMP2照会
 *
 * @author emarfkrow
 */
public class T05Comp2GetAction extends BaseAction {

    /** T05_COMP2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref1Id = postJson.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = postJson.get("T05Comp2.ref1Id");
        }
        if (ref1Id == null) {
            isAllKey = false;
        }

        Object ref2Id = postJson.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = postJson.get("T05Comp2.ref2Id");
        }
        if (ref2Id == null) {
            isAllKey = false;
        }

        Object ref3Id = postJson.get("ref3Id");
        if (ref3Id == null) {
            ref3Id = postJson.get("T05Comp2.ref3Id");
        }
        if (ref3Id == null) {
            isAllKey = false;
        }

        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("T05Comp2.tekiyoBi");
        }
        if (tekiyoBi == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T05Comp1 t05Comp1 = com.example.entity.T05Comp1.get(ref1Id, ref2Id);
            map.put("T05Comp1", t05Comp1);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T05Comp2 t05Comp2 = T05Comp2.get(ref1Id, ref2Id, ref3Id, tekiyoBi);
            map.put("T05Comp2", t05Comp2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
