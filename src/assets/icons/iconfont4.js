/* eslint-disable */
!function (e) {
    var t, n, o, i, c,
        a = '<svg>\n' +
            '    <symbol id="icon-xihuan" viewBox="0 0 1206 1024">\n' +
            '        <path fill="#1E90FF"  d="M1114.966864 91.038469a325.553663 325.553663 0 0 0-451.609796 0l-15.96711 15.60173a63.86844 63.86844 0 0 1-88.970053 0l-15.96711-15.60173a325.553663 325.553663 0 0 0-451.609795 0c-124.229232 121.269653-146.152037 430.23506 95.729584 678.839676a1065.594504 1065.594504 0 0 0 360.228234 242.795072 151.267359 151.267359 0 0 0 112.244765 0 1065.48489 1065.48489 0 0 0 360.228234-242.795072c241.91816-248.458464 219.849202-557.423871 95.729585-678.839676z m0 0"></path>\n' +
            '    </symbol>\n' +
            '    <symbol id="icon-xihuan1" viewBox="0 0 1166 1024">\n' +
            '        <path d="M882.058985 2.769416C863.503898 0.969296 845.641165 0 829.024669 0c-115.623117 0-184.166162 42.510535-246.201079 107.868752C512.341954 33.094521 431.751949-11.631547 283.588195 2.769416 158.964476 14.954846 17.170379 124.623718 0 336.345569v69.235399C13.84708 589.470188 142.486451 739.434063 507.495476 999.897634a129.331726 129.331726 0 0 0 150.379287 0c365.285966-261.017455 493.371454-410.981329 507.633946-594.870549v-69.235399C1148.476801 124.623718 1006.682703 14.954846 882.058985 2.769416z m189.843464 339.253456v57.465381C1059.301607 550.006011 941.601428 682.245623 603.59421 923.046341a35.725466 35.725466 0 0 1-41.54124 0C224.738106 682.384094 106.345573 550.006011 93.74473 399.488253V342.022872c13.84708-156.887414 112.438288-237.477419 198.982538-245.924138 15.370259-1.523179 30.186634-2.215533 43.895243-2.215533 96.929559 0 143.455747 35.448524 210.337142 115.069234l35.863937 42.787476 36.002408-42.787476c66.742925-79.620709 112.992171-115.069233 210.198671-115.069234 13.84708 0 28.524984 0 43.895243 2.215533 86.544249 8.446719 185.55087 89.036723 198.982537 245.924138z"\n' +
            '              fill="#1E90FF"></path>\n' +
            '    </symbol>\n' +
            '    <symbol id="icon-xunhuan" viewBox="0 0 1066 1024">\n' +
            '        <path fill="#1E90FF" d="M725.333333 170.666667V88.234667a21.333333 21.333333 0 0 1 34.986667-16.426667l175.786667 146.474667a21.333333 21.333333 0 0 1-13.696 37.717333H85.333333V170.666667h640zM85.333333 768h853.333334v85.333333H85.333333v-85.333333z m0-298.666667h853.333334v85.333334H85.333333v-85.333334z" p-id="3253"></path>\n' +
            '    </symbol>\n' +
            '    <symbol id="icon-xunhuan1" viewBox="0 0 1142 1024">\n' +
            '        <path fill="#1E90FF" d="M768 763.008V682.666667l213.333333 128-213.333333 128v-89.173334a384 384 0 0 1-298.538667-228.906666L469.333333 620.373333l-0.128 0.256A384 384 0 0 1 116.266667 853.333333H85.333333v-85.333333h30.933334a298.666667 298.666667 0 0 0 274.517333-181.034667L422.912 512l-32.128-74.965333A298.666667 298.666667 0 0 0 116.266667 256H85.333333V170.666667h30.933334a384 384 0 0 1 352.938666 232.746666L469.333333 403.626667l0.128-0.256A384 384 0 0 1 768 174.506667V85.333333l213.333333 128-213.333333 128V260.992a298.666667 298.666667 0 0 0-220.117333 176.042667L515.754667 512l32.128 74.965333A298.666667 298.666667 0 0 0 768 763.008z" p-id="3398"></path>\n' +
            '    </symbol>\n' +
            '</svg>',
        l = (l = document.getElementsByTagName("script"))[l.length - 1].getAttribute("data-injectcss"),
        d = function (e, t) {
            t.parentNode.insertBefore(e, t)
        };
    if (l && !e.__iconfont__svg__cssinject__) {
        e.__iconfont__svg__cssinject__ = !0;
        try {
            document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>")
        } catch (e) {
            console && console.log(e)
        }
    }

    function s() {
        c || (c = !0, o())
    }

    function h() {
        try {
            i.documentElement.doScroll("left")
        } catch (e) {
            return void setTimeout(h, 50)
        }
        s()
    }

    t = function () {
        var e, t = document.createElement("div");
        t.innerHTML = a, a = null, (t = t.getElementsByTagName("svg")[0]) && (t.setAttribute("aria-hidden", "true"), t.style.position = "absolute", t.style.width = 0, t.style.height = 0, t.style.overflow = "hidden", t = t, (e = document.body).firstChild ? d(t, e.firstChild) : e.appendChild(t))
    }, document.addEventListener ? ~["complete", "loaded", "interactive"].indexOf(document.readyState) ? setTimeout(t, 0) : (n = function () {
        document.removeEventListener("DOMContentLoaded", n, !1), t()
    }, document.addEventListener("DOMContentLoaded", n, !1)) : document.attachEvent && (o = t, i = e.document, c = !1, h(), i.onreadystatechange = function () {
        "complete" == i.readyState && (i.onreadystatechange = null, s())
    })
}(window);