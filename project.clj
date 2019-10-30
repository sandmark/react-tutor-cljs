(defproject react-tutor-cljs "0.1.0-SNAPSHOT"
  :description "react-tutor-cljs: A React (Reagent) tutorial app"
  :url "https://github.com/sandmark/react-tutor-cljs/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"]]
  :repl-options {:init-ns react-tutor-cljs.core}

  :resource-paths ["resources" "target"]
  :profiles
  {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.3"]
                        [com.bhauman/rebel-readline-cljs "0.1.4"]]}}
  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]})
