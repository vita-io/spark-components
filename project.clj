(defproject vita-io/spark-component "0.1.0"
  :description "Component to start/stop spark-context"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure         "1.7.0"]
                 [com.stuartsierra/component  "0.3.0"]
                 [yieldbot/flambo             "0.7.1"]]

  :profiles {
    :provided {
      :dependencies [[org.apache.spark/spark-core_2.10 "1.5.0"]]
    }
  })
