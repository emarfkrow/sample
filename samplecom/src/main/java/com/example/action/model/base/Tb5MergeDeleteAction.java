package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Merge;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 統合削除
 *
 * @author emarfkrow
 */
public class Tb5MergeDeleteAction extends BaseAction {

    /** 統合削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object mergeId = postJson.get("mergeId");
        if (mergeId == null) {
            mergeId = postJson.get("Tb5Merge.mergeId");
        }
        if (mergeId == null) {
            throw new OptLockError("error.cant.delete", "統合");
        }

        Tb5Merge e = FormValidator.toBean(Tb5Merge.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "統合");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
