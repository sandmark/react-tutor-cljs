(ns react-tutor-cljs.core
  (:require [goog.dom :as gdom]
            [reagent.core :as reagent]))

(enable-console-print!)

(defn shopping-list [{:keys [name]}]
  [:div {:className "shopping-list"}
   [:h1 "Shopping List for " name]
   [:ul
    [:li "Instagram"]
    [:li "WhatsApp"]
    [:li "Oculus"]]])
(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [element]
  "Renders *initial* component to DOM object `element`."
  (reagent/render-component [shopping-list {:name "Mark"}] element))

(defn mount-app-element []
  (when-let [element (get-app-element)]
    (mount element)))

;; enable to start app without `on-reload` function with ^:after-load metadata.
;; this would be helpful for testing this ns without launching the app
(mount-app-element)


;; ^:after-load means the function should be called when the app was loaded.
(defn ^:after-load on-reload []
  (mount-app-element))
