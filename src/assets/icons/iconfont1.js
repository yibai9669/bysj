/* eslint-disable */
!function (d) {
    var t,
        n = '<svg>\n' +
            '    <symbol id="icon-liebiao" viewBox="0 0 1024 1024">\n' +
            '       <path fill="#1E90FF" d="M85.333333 768h426.666667v85.333333H85.333333v-85.333333z m0-298.666667h597.333334v85.333334H85.333333v-85.333334z m0-298.666666h853.333334v85.333333H85.333333V170.666667z m725.333334 476.586666V384h213.333333v85.333333h-128v298.666667a128 128 0 1 1-85.333333-120.746667zM768 810.666667a42.666667 42.666667 0 1 0 0-85.333334 42.666667 42.666667 0 0 0 0 85.333334z" p-id="3539"></path>\n' +
            '    </symbol>\n' +
            '    <symbol id="icon-xiazai" viewBox="0 0 1024 1024">\n' +
            '            <path d="M960 467.2a44.8 44.8 0 0 1 44.8 44.8v448a44.8 44.8 0 0 1-44.8 44.8H64a44.8 44.8 0 0 1-44.8-44.8V512.192a44.8 44.8 0 1 1 89.6 0V915.2h806.4V512a44.8 44.8 0 0 1 38.72-44.416L960 467.2zM511.808 19.2a44.8 44.8 0 0 1 44.8 44.8l-0.064 489.472 163.776-163.84a44.8 44.8 0 0 1 57.792-4.672l5.568 4.672a44.8 44.8 0 0 1 0 63.36l-240 240a44.8 44.8 0 0 1-63.36 0l-240-240a44.8 44.8 0 0 1 0-63.36l5.568-4.672a44.8 44.8 0 0 1 57.792 4.672L466.944 552.96V64a44.8 44.8 0 0 1 38.784-44.416z"\n' +
            '                  fill="#1E90FF" p-id="1567"></path>\n' +
            '    </symbol>\n' +
            '</svg>',
        e = (t = document.getElementsByTagName("script"))[t.length - 1].getAttribute("data-injectcss");
    if (e && !d.__iconfont__svg__cssinject__) {
        d.__iconfont__svg__cssinject__ = !0;
        try {
            document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>")
        } catch (t) {
            console && console.log(t)
        }
    }
    !function (t) {
        if (document.addEventListener) if (~["complete", "loaded", "interactive"].indexOf(document.readyState)) setTimeout(t, 0); else {
            var e = function () {
                document.removeEventListener("DOMContentLoaded", e, !1), t()
            };
            document.addEventListener("DOMContentLoaded", e, !1)
        } else document.attachEvent && (n = t, i = d.document, o = !1, l = function () {
            o || (o = !0, n())
        }, (c = function () {
            try {
                i.documentElement.doScroll("left")
            } catch (t) {
                return void setTimeout(c, 50)
            }
            l()
        })(), i.onreadystatechange = function () {
            "complete" == i.readyState && (i.onreadystatechange = null, l())
        });
        var n, i, o, l, c
    }(function () {
        var t, e;
        (t = document.createElement("div")).innerHTML = n, n = null, (e = t.getElementsByTagName("svg")[0]) && (e.setAttribute("aria-hidden", "true"), e.style.position = "absolute", e.style.width = 0, e.style.height = 0, e.style.overflow = "hidden", function (t, e) {
            e.firstChild ? function (t, e) {
                e.parentNode.insertBefore(t, e)
            }(t, e.firstChild) : e.appendChild(t)
        }(e, document.body))
    })
}(window);
