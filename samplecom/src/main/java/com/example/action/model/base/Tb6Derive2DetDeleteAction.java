package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Derive2Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２明細削除
 *
 * @author emarfkrow
 */
public class Tb6Derive2DetDeleteAction extends BaseAction {

    /** 派生２明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("Tb6Derive2Det.derive2Id");
        }
        if (derive2Id == null) {
            throw new OptLockError("error.cant.delete", "派生２明細");
        }
        Object derive2Bn = postJson.get("derive2Bn");
        if (derive2Bn == null) {
            derive2Bn = postJson.get("Tb6Derive2Det.derive2Bn");
        }
        if (derive2Bn == null) {
            throw new OptLockError("error.cant.delete", "派生２明細");
        }

        Tb6Derive2Det e = FormValidator.toBean(Tb6Derive2Det.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生２明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
