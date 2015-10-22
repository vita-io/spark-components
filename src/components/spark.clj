(ns components.spark
  (:require [flambo.api :as f]
            [com.stuartsierra.component :as component])
  (:import  [org.apache.spark.api.java JavaSparkContext]
            [org.apache.spark SparkConf]))

(defrecord Spark [^SparkConf config ^JavaSparkContext context]
  component/Lifecycle

  (start [component]
    (if-not context
      (assoc component :context (f/spark-context config))
      component))

  (stop [component]
    (if context
      (do (.stop context)
          (dissoc component :context))
      component)))


(defn new-spark [config]
  (map->Spark {:config config}))