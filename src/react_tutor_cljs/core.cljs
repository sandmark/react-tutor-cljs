(ns react-tutor-cljs.core
  (:require [goog.dom :as gdom]
            [reagent.core :as reagent]))

(enable-console-print!)

(defn square [{:keys [value]}]
  [:button {:className "square"} value])

(defn board []
  (letfn [(render-square [i]
            [square {:value i}])]
    [:div
     [:div {:className "status"} "Next player: X"]
     [:div {:className "board-row"}
      [render-square 0]
      [render-square 1]
      [render-square 2]]
     [:div {:className "board-row"}
      [render-square 3]
      [render-square 4]
      [render-square 5]]
     [:div {:className "board-row"}
      [render-square 6]
      [render-square 7]
      [render-square 8]]]))

(defn game []
  [:div {:className "game"}
   [:div {:className "game-board"}
    [board]]
   [:div {:className "game-info"}
    [:div
     ;; status
     ]
    [:ol
     ;; TODO
     ]]])

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [element]
  "Renders *initial* component to DOM object `element`."
  (reagent/render-component [game] element))

(defn mount-app-element []
  (when-let [element (get-app-element)]
    (mount element)))

;; enable to start app without `on-reload` function with ^:after-load metadata.
;; this would be helpful for testing this ns without launching the app
(mount-app-element)


;; ^:after-load means the function should be called when the app was loaded.
(defn ^:after-load on-reload []
  (mount-app-element))
