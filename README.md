# Spark Component

A Clojure component to manage the lifecycle of a Spark-context using
[Flambo](https://github.com/yieldbot/flambo) and [the component
pattern by Stuart Sierra](https://github.com/stuartsierra/component).

## Installation

[![Clojars Project](http://clojars.org/vita-io/spark-component/latest-version.svg)](http://clojars.org/vita-io/spark-component)

## Usage

```clojure

(ns my-app
  (:require [components.spark :refer [new-spark]]
            [flambo.conf      :as conf]))


(defn my-system [config]
  (let [spark-config (-> (conf/spark-conf)
                         (conf/master   (config :spark-master-url "local"))
                         (conf/app-name (config :spark-app-name "my_app")))]
    (component/system-map
      :spark (new-spark spark-config))))


(defn -main []
  (let [s (component/start
            (my-system {:spark-master-url "local" :spark-app-name "my_app"}))]
    ;... spark-job
    ))

```

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
