package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Noref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * NO参照マスタ削除
 *
 * @author emarfkrow
 */
public class Tb1NorefDeleteAction extends BaseAction {

    /** NO参照マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object norefNo = postJson.get("norefNo");
        if (norefNo == null) {
            norefNo = postJson.get("Tb1Noref.norefNo");
        }
        if (norefNo == null) {
            throw new OptLockError("error.cant.delete", "NO参照マスタ");
        }

        Tb1Noref e = FormValidator.toBean(Tb1Noref.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "NO参照マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
