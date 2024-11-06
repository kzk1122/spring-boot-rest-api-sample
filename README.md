# spring-boot-rest-api-sample
Java + Spring boot を使用しCRUD 操作する下記APIを作成するためのサンプルプロジェクトです。
現状ローカル環境での起動のみとなります。

作成するAPI
- ユーザー登録API
- ユーザー一覧取得API
- ユーザー情報取得API
- ユーザー情報更新API
- ユーザー削除API

API仕様については`openapi.yml`に記載しています。

## 事前準備

事前に下記のインストールを行ってください

### VSCode

VSCodeを使う環境を前提としているため、VSCodeを事前にインストールしてください。
他のIDEを使ってもよいですが動作保証はしないので自己責任で設定してください。

https://code.visualstudio.com/

VSCodeインストール後下記の拡張機能をインストールしてください。
- Extention Pack for Java Auto Config

### Docker Desktop
DB(mysql)をdockerで起動するのに使うため、下記よりインストールしてください。
docker-desktopを起動しないとdockerコマンドに失敗するため起動した状態で作業してください。
docker起動できるなら他の方法で構築してもよいです。  
https://www.docker.com/ja-jp/products/docker-desktop/

### DBクライアントツール
データベースに登録されている情報を見るために使用します。
DBeaver推奨。Community版をインストールしてください。  
ダウンロードページ  
https://dbeaver.io/download/

MySQL Workbenchのような他のDBクライアントなり直接Mysqlに接続して中身を見るでも可です  

接続情報は.env参照（パスワードは自分で好きな値を設定すること）

### Postman
GUIでAPIを実行するのに使用します。
他のツール使ってもcurlで実行しても可。

https://www.postman.com/downloads/

Postmanで今回作成するAPIを実行するための設定のcollectionを`postman/spring_boot_api.postman_collection.json`にまとめています。
postmanにimportすることで利用可能です。  
https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-and-exporting-overview/

## 初期設定

.envの`DB_ROOT_PASSWORD`と`DB_PASSWORD`を任意のパスワードに修正してください。  
`restapi/src/main/resources/application.properties`の`spring.datasource.password`に`DB_PASSWORD`に設定したものと同じパスワードを設定してください。

compose.ymlがある階層で`docker compose up -d`コマンドを実行してください。
docker上でMySQLの起動とテーブル作成、初期データの設定がおこなわれます。
うまく起動しない場合は`docker compose up`でログを確認しエラーが出てないか確認してください。  
mysql 起動後、`RestapiApplication.java`のファイルを右クリック->Run JavaでSpring Bootを起動してください。  
ヘルスチェックAPIを実行し下記のレスポンスが返却されればOKです。

curlによる実行例
``` bash
curl http://localhost:8080/api/health
{"message":"api call success!!!"}%
```

注）APIを実行する際のURLは下記のように設定してください。
```http://localhost:8080/api/{実行したいAPIのパスを指定}```

## dockerを停止したい場合
`docker compose down` でdockerを停止できます。

## DBの変更を行なった場合
テーブル追加やカラム変更などDBの変更を行なった場合は、`docker compose down --volumes`でDBのデータを保存しているvolumeごと削除してから`docker compose up -d`を実行してください。

## MySQLの起動確認について
`docker ps`コマンドでMySQLが起動しているか確認できます。起動している場合下記のように表示されます。
`mysql_sample_db`が表示されていればOKです。


``` bash
docker ps
CONTAINER ID   IMAGE         COMMAND                  CREATED          STATUS          PORTS                               NAMES
b0086f47949f   mysql:8.2.0   "docker-entrypoint.s…"   23 seconds ago   Up 22 seconds   0.0.0.0:3306->3306/tcp, 33060/tcp   mysql_sample_db
```

## バージョン
Java: OpenJDK 17  
Spring boot: 3.2.5  d
MySQL: 8.2.0

## TODO
- サーバー上で起動
- ログ設定