package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * IDマスタ削除
 *
 * @author emarfkrow
 */
public class M05IdDeleteAction extends BaseAction {

    /** IDマスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("M05Id.idrefId");
        }
        if (idrefId == null) {
            throw new OptLockError("error.cant.delete", "IDマスタ");
        }

        M05Id e = FormValidator.toBean(M05Id.class.getName(), postJson);

        java.util.List<com.example.entity.M05Idbn> m05Idbns = e.referM05Idbns();
        if (m05Idbns != null) {
            for (com.example.entity.M05Idbn m05Idbn : m05Idbns) {

                if (m05Idbn.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "ID連番マスタ");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "IDマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
