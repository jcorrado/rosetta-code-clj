(defproject read-conf-file "0.1.0"
  :description "Clojure solution to Rosetta Code 'Read a configuration file' task"
  :url "http://www.rosettacode.org/wiki/Read_a_configuration_file"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :main ^:skip-aot read-conf-file.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
