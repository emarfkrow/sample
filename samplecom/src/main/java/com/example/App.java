package com.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import jp.co.golorp.emarf.generator.BeanGenerator;
import jp.co.golorp.emarf.util.ResourceBundles;

/**
 * Hello world!
 *
 */
public final class App {

    /**
     * プライベートコンストラクタ
     */
    private App() {
    }

    /**
     * エントリポイント
     *
     * @param args コマンドライン引数
     */
    public static void main(final String[] args) {

        //プロジェクトパスを取得
        Path currentPath = Paths.get("");

        //パスの文字列を取得
        String absolutePath = currentPath.toAbsolutePath().toString();

        //ソースパスにプロジェクトパスのリソースフォルダを追加
        ResourceBundles.getSrcPaths().add(absolutePath + File.separator + "src\\main\\resources");

        //ジェネレータ起動
        BeanGenerator.generate(absolutePath);
    }
}
