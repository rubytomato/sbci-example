# 概要

Spring-Bootを使用したWebアプリケーションをCircleCIでビルドするサンプルアプリケーションです。

**環境**

* Java 1.8.0_60
* Spring-Boot 1.3.0.M5
* MySQL 5.6

**ビルド**

```
> mvn clean site
```

**ログファイル**

デフォルトではプロジェクトのルートディレクトリ/log下に出力されます。ログの出力先は環境変数log.dirで変えることができます。

```
> mvn spring-boot:run -Dlog.dir=/path/to/logdir
```