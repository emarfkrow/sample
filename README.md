# DB-First Web Application Generator

**DB設計から業務Webシステムを自動生成する  
再生成しても壊れない Java Servlet ベース OSS**

---

## What is this?

働き手不足が進行する中、  
業務システム開発の現場では **限られた人員で、より多くのシステムを  
安定した品質で開発・保守すること** が求められています。

本OSSは、既存のデータベース定義（DDL）を起点に、  
検索画面・CRUD単票画面を含む業務Webアプリケーションを  
**自動生成**するフレームワークです。

DB設計を正とし、生成後は継承によって安全にカスタマイズ可能です。  
DDL変更後も **再生成によるデグレは発生しません。**

---

## Features

- テーブルから CRUD 単票画面を自動生成
- ビューから検索画面を自動生成
- Java Servlet ベースの3階層構成
- 認証・認可機能を標準搭載
- トランザクション管理を標準搭載
- アノテーションによるバリデーション定義
- カスタムバリデーション対応
- DB方言はサブクラスで吸収
- **再生成してもカスタマイズコードは壊れません**

---

## Why this exists

働き手不足の現場では、

- 実装を人手で量産すること
- 属人化した開発を維持すること
- 再生成による手戻りを許容すること

が大きな負担になります。

本OSSは、

- DB設計ができる少数の人材を起点に
- 実装を自動生成し
- 実プロジェクトでは継承によって安全に拡張する

というアプローチにより、  
**人に依存しすぎない業務Webシステム開発**を実現します。

---

## Who should use this?

### 向いている人

- Java Servlet ベースの業務Webシステムを開発している
- DB設計を重視している
- 働き手不足の中で開発工数を削減したい
- CRUD実装や検索画面作成を効率化したい
- 自動生成後も手動でロジックを追加したい

### 向いていない人

- React / SPA 前提のフロントエンド開発
- ノーコード／ローコードツールを求める人
- DB設計ルールを設けたくない場合

---

## Architecture

    Database
      |
      v
    DDL
      |
      v
    Generated Project (read-only, auto-generated)
      |
      v  (extend)
    Application Project (custom implementation)

再生成しても **Application Project のコードは影響を受けません。**

---

## Get Started

- [Quick Start](docs/quickstart.md)
- [DB Design Guideline](docs/db-design-guideline.md)
- [Sample Application](https://github.com/emarfkrow/sample)

---

## License

This project is released as Open Source Software.

---

## Philosophy

本OSSは、自由度よりも

- 保守性
- 再生成耐性
- 業務システムの安定運用

を優先しています。

働き手不足の時代においても、  
**DB設計を正として、安全に業務Webシステムを量産できる開発基盤**  
であることを目指しています。

