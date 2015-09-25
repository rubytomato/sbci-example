# 概要

Spring-Bootを使用したWebアプリケーションをCircleCIでビルドするサンプルアプリケーションです。

[![Circle CI](https://circleci.com/gh/rubytomato/sbci-example.svg?style=svg&circle-token=49c0c31ffa73506b2a2bb5351cfc2c37525610db)](https://circleci.com/gh/rubytomato/sbci-example)

**環境**

* Java 1.8.0_60
* Spring-Boot 1.3.0.M5
* MySQL 5.6


## ビルド

```
> mvn clean site
```

**実行**

```
> java -jar sbci-example-1.0-SNAPSHOT.jar
```

カスタマー一覧

http://localhost:9000/customer/

オーダー一覧

http://localhost:9000/orders/


### ログファイル

デフォルトではアプリケーションの実行ディレクトリ下のlogディレクトリに出力されます。ログの出力先は環境変数log.dirで変えることができます。

```
> java -jar sbci-example-1.0-SNAPSHOT.jar -Dlog.dir=/path/to/logdir
```

## MySQL

データベース名: sample_db
アカウント: test_user/test_user

データベースやテーブルを作成するsqlはsrc/main/resources/data/sql下で管理しています。

* 00-database.sql : データベース、アカウントを作成するsql
* 01-schema.sql : テーブルを作成するsql
* 02-data-customer.sql : カスタマー
* 03-data-orders.sql : 注文
* 04-data-order_detail.sql : 注文明細
* 05-data-payment.sql : 支払い
* 06-data-product.sql : 製品
* 07-data-product_line.sql : 製品種別 
