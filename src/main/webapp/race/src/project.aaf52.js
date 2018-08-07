require=function i(c,a,s){function u(t,e){if(!a[t]){if(!c[t]){var n="function"==typeof require&&require;if(!e&&n)return n(t,!0);if(l)return l(t,!0);var o=new Error("Cannot find module '"+t+"'");throw o.code="MODULE_NOT_FOUND",o}var r=a[t]={exports:{}};c[t][0].call(r.exports,function(e){return u(c[t][1][e]||e)},r,r.exports,i,c,a,s)}return a[t].exports}for(var l="function"==typeof require&&require,e=0;e<s.length;e++)u(s[e]);return u}({1:[function(e,t,n){var o,r,i=t.exports={};function c(){throw new Error("setTimeout has not been defined")}function a(){throw new Error("clearTimeout has not been defined")}function s(t){if(o===setTimeout)return setTimeout(t,0);if((o===c||!o)&&setTimeout)return o=setTimeout,setTimeout(t,0);try{return o(t,0)}catch(e){try{return o.call(null,t,0)}catch(e){return o.call(this,t,0)}}}(function(){try{o="function"==typeof setTimeout?setTimeout:c}catch(e){o=c}try{r="function"==typeof clearTimeout?clearTimeout:a}catch(e){r=a}})();var u,l=[],f=!1,d=-1;function p(){f&&u&&(f=!1,u.length?l=u.concat(l):d=-1,l.length&&h())}function h(){if(!f){var e=s(p);f=!0;for(var t=l.length;t;){for(u=l,l=[];++d<t;)u&&u[d].run();d=-1,t=l.length}u=null,f=!1,function(t){if(r===clearTimeout)return clearTimeout(t);if((r===a||!r)&&clearTimeout)return r=clearTimeout,clearTimeout(t);try{r(t)}catch(e){try{return r.call(null,t)}catch(e){return r.call(this,t)}}}(e)}}function m(e,t){this.fun=e,this.array=t}function g(){}i.nextTick=function(e){var t=new Array(arguments.length-1);if(1<arguments.length)for(var n=1;n<arguments.length;n++)t[n-1]=arguments[n];l.push(new m(e,t)),1!==l.length||f||s(h)},m.prototype.run=function(){this.fun.apply(null,this.array)},i.title="browser",i.browser=!0,i.env={},i.argv=[],i.version="",i.versions={},i.on=g,i.addListener=g,i.once=g,i.off=g,i.removeListener=g,i.removeAllListeners=g,i.emit=g,i.prependListener=g,i.prependOnceListener=g,i.listeners=function(e){return[]},i.binding=function(e){throw new Error("process.binding is not supported")},i.cwd=function(){return"/"},i.chdir=function(e){throw new Error("process.chdir is not supported")},i.umask=function(){return 0}},{}],axios:[function(e,n,o){(function(u){"use strict";cc._RF.push(n,"090c2iA9PVPpo2OHoTwg4Ba","axios");var e,t,l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e};t=function(){return function(n){function o(e){if(r[e])return r[e].exports;var t=r[e]={exports:{},id:e,loaded:!1};return n[e].call(t.exports,t,t.exports,o),t.loaded=!0,t.exports}var r={};return o.m=n,o.c=r,o.p="",o(0)}([function(e,t,n){e.exports=n(1)},function(e,t,n){function o(e){var t=new c(e),n=i(c.prototype.request,t);return r.extend(n,c.prototype,t),r.extend(n,t),n}var r=n(2),i=n(3),c=n(5),a=n(6),s=o(a);s.Axios=c,s.create=function(e){return o(r.merge(a,e))},s.Cancel=n(23),s.CancelToken=n(24),s.isCancel=n(20),s.all=function(e){return Promise.all(e)},s.spread=n(25),e.exports=s,e.exports.default=s},function(e,t,n){function i(e){return"[object Array]"===u.call(e)}function o(e){return null!==e&&"object"==(void 0===e?"undefined":l(e))}function r(e){return"[object Function]"===u.call(e)}function c(e,t){if(null!=e)if("object"!=(void 0===e?"undefined":l(e))&&(e=[e]),i(e))for(var n=0,o=e.length;n<o;n++)t.call(null,e[n],n,e);else for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.call(null,e[r],r,e)}var a=n(3),s=n(4),u=Object.prototype.toString;e.exports={isArray:i,isArrayBuffer:function(e){return"[object ArrayBuffer]"===u.call(e)},isBuffer:s,isFormData:function(e){return"undefined"!=typeof FormData&&e instanceof FormData},isArrayBufferView:function(e){return"undefined"!=typeof ArrayBuffer&&ArrayBuffer.isView?ArrayBuffer.isView(e):e&&e.buffer&&e.buffer instanceof ArrayBuffer},isString:function(e){return"string"==typeof e},isNumber:function(e){return"number"==typeof e},isObject:o,isUndefined:function(e){return void 0===e},isDate:function(e){return"[object Date]"===u.call(e)},isFile:function(e){return"[object File]"===u.call(e)},isBlob:function(e){return"[object Blob]"===u.call(e)},isFunction:r,isStream:function(e){return o(e)&&r(e.pipe)},isURLSearchParams:function(e){return"undefined"!=typeof URLSearchParams&&e instanceof URLSearchParams},isStandardBrowserEnv:function(){return("undefined"==typeof navigator||"ReactNative"!==navigator.product)&&"undefined"!=typeof window&&"undefined"!=typeof document},forEach:c,merge:function n(){function e(e,t){"object"==l(o[t])&&"object"==(void 0===e?"undefined":l(e))?o[t]=n(o[t],e):o[t]=e}for(var o={},t=0,r=arguments.length;t<r;t++)c(arguments[t],e);return o},extend:function(n,e,o){return c(e,function(e,t){n[t]=o&&"function"==typeof e?a(e,o):e}),n},trim:function(e){return e.replace(/^\s*/,"").replace(/\s*$/,"")}}},function(e,t){e.exports=function(n,o){return function(){for(var e=new Array(arguments.length),t=0;t<e.length;t++)e[t]=arguments[t];return n.apply(o,e)}}},function(e,t){function n(e){return!!e.constructor&&"function"==typeof e.constructor.isBuffer&&e.constructor.isBuffer(e)}e.exports=function(e){return null!=e&&(n(e)||"function"==typeof(t=e).readFloatLE&&"function"==typeof t.slice&&n(t.slice(0,0))||!!e._isBuffer);var t}},function(e,t,n){function r(e){this.defaults=e,this.interceptors={request:new c,response:new c}}var o=n(6),i=n(2),c=n(17),a=n(18);r.prototype.request=function(e){"string"==typeof e&&(e=i.merge({url:e},arguments[1])),(e=i.merge(o,{method:"get"},this.defaults,e)).method=e.method.toLowerCase();var t=[a,void 0],n=Promise.resolve(e);for(this.interceptors.request.forEach(function(e){t.unshift(e.fulfilled,e.rejected)}),this.interceptors.response.forEach(function(e){t.push(e.fulfilled,e.rejected)});t.length;)n=n.then(t.shift(),t.shift());return n},i.forEach(["delete","get","head","options"],function(n){r.prototype[n]=function(e,t){return this.request(i.merge(t||{},{method:n,url:e}))}}),i.forEach(["post","put","patch"],function(o){r.prototype[o]=function(e,t,n){return this.request(i.merge(n||{},{method:o,url:e,data:t}))}}),e.exports=r},function(e,t,n){function o(e,t){!i.isUndefined(e)&&i.isUndefined(e["Content-Type"])&&(e["Content-Type"]=t)}var r,i=n(2),c=n(7),a={"Content-Type":"application/x-www-form-urlencoded"},s={adapter:("undefined"!=typeof XMLHttpRequest?r=n(8):void 0!==u&&(r=n(8)),r),transformRequest:[function(e,t){return c(t,"Content-Type"),i.isFormData(e)||i.isArrayBuffer(e)||i.isBuffer(e)||i.isStream(e)||i.isFile(e)||i.isBlob(e)?e:i.isArrayBufferView(e)?e.buffer:i.isURLSearchParams(e)?(o(t,"application/x-www-form-urlencoded;charset=utf-8"),e.toString()):i.isObject(e)?(o(t,"application/json;charset=utf-8"),JSON.stringify(e)):e}],transformResponse:[function(e){if("string"==typeof e)try{e=JSON.parse(e)}catch(e){}return e}],timeout:0,xsrfCookieName:"XSRF-TOKEN",xsrfHeaderName:"X-XSRF-TOKEN",maxContentLength:-1,validateStatus:function(e){return 200<=e&&e<300}};s.headers={common:{Accept:"application/json, text/plain, */*"}},i.forEach(["delete","get","head"],function(e){s.headers[e]={}}),i.forEach(["post","put","patch"],function(e){s.headers[e]=i.merge(a)}),e.exports=s},function(e,t,n){var r=n(2);e.exports=function(n,o){r.forEach(n,function(e,t){t!==o&&t.toUpperCase()===o.toUpperCase()&&(n[o]=e,delete n[t])})}},function(e,t,d){var p=d(2),h=d(9),m=d(12),g=d(13),v=d(14),y=d(10),w="undefined"!=typeof window&&window.btoa&&window.btoa.bind(window)||d(15);e.exports=function(f){return new Promise(function(n,o){var r=f.data,i=f.headers;p.isFormData(r)&&delete i["Content-Type"];var c=new XMLHttpRequest,e="onreadystatechange",a=!1;if("undefined"==typeof window||!window.XDomainRequest||"withCredentials"in c||v(f.url)||(c=new window.XDomainRequest,e="onload",a=!0,c.onprogress=function(){},c.ontimeout=function(){}),f.auth){var t=f.auth.username||"",s=f.auth.password||"";i.Authorization="Basic "+w(t+":"+s)}if(c.open(f.method.toUpperCase(),m(f.url,f.params,f.paramsSerializer),!0),c.timeout=f.timeout,c[e]=function(){if(c&&(4===c.readyState||a)&&(0!==c.status||c.responseURL&&0===c.responseURL.indexOf("file:"))){var e="getAllResponseHeaders"in c?g(c.getAllResponseHeaders()):null,t={data:f.responseType&&"text"!==f.responseType?c.response:c.responseText,status:1223===c.status?204:c.status,statusText:1223===c.status?"No Content":c.statusText,headers:e,config:f,request:c};h(n,o,t),c=null}},c.onerror=function(){o(y("Network Error",f,null,c)),c=null},c.ontimeout=function(){o(y("timeout of "+f.timeout+"ms exceeded",f,"ECONNABORTED",c)),c=null},p.isStandardBrowserEnv()){var u=d(16),l=(f.withCredentials||v(f.url))&&f.xsrfCookieName?u.read(f.xsrfCookieName):void 0;l&&(i[f.xsrfHeaderName]=l)}if("setRequestHeader"in c&&p.forEach(i,function(e,t){void 0===r&&"content-type"===t.toLowerCase()?delete i[t]:c.setRequestHeader(t,e)}),f.withCredentials&&(c.withCredentials=!0),f.responseType)try{c.responseType=f.responseType}catch(n){if("json"!==f.responseType)throw n}"function"==typeof f.onDownloadProgress&&c.addEventListener("progress",f.onDownloadProgress),"function"==typeof f.onUploadProgress&&c.upload&&c.upload.addEventListener("progress",f.onUploadProgress),f.cancelToken&&f.cancelToken.promise.then(function(e){c&&(c.abort(),o(e),c=null)}),void 0===r&&(r=null),c.send(r)})}},function(e,t,n){var r=n(10);e.exports=function(e,t,n){var o=n.config.validateStatus;n.status&&o&&!o(n.status)?t(r("Request failed with status code "+n.status,n.config,null,n.request,n)):e(n)}},function(e,t,n){var c=n(11);e.exports=function(e,t,n,o,r){var i=new Error(e);return c(i,t,n,o,r)}},function(e,t){e.exports=function(e,t,n,o,r){return e.config=t,n&&(e.code=n),e.request=o,e.response=r,e}},function(e,t,n){function i(e){return encodeURIComponent(e).replace(/%40/gi,"@").replace(/%3A/gi,":").replace(/%24/g,"$").replace(/%2C/gi,",").replace(/%20/g,"+").replace(/%5B/gi,"[").replace(/%5D/gi,"]")}var c=n(2);e.exports=function(e,t,n){if(!t)return e;var o;if(n)o=n(t);else if(c.isURLSearchParams(t))o=t.toString();else{var r=[];c.forEach(t,function(e,t){null!=e&&(c.isArray(e)?t+="[]":e=[e],c.forEach(e,function(e){c.isDate(e)?e=e.toISOString():c.isObject(e)&&(e=JSON.stringify(e)),r.push(i(t)+"="+i(e))}))}),o=r.join("&")}return o&&(e+=(-1===e.indexOf("?")?"?":"&")+o),e}},function(e,t,n){var i=n(2),c=["age","authorization","content-length","content-type","etag","expires","from","host","if-modified-since","if-unmodified-since","last-modified","location","max-forwards","proxy-authorization","referer","retry-after","user-agent"];e.exports=function(e){var t,n,o,r={};return e&&i.forEach(e.split("\n"),function(e){if(o=e.indexOf(":"),t=i.trim(e.substr(0,o)).toLowerCase(),n=i.trim(e.substr(o+1)),t){if(r[t]&&0<=c.indexOf(t))return;r[t]="set-cookie"===t?(r[t]?r[t]:[]).concat([n]):r[t]?r[t]+", "+n:n}}),r}},function(e,t,n){var c=n(2);e.exports=c.isStandardBrowserEnv()?function(){function n(e){var t=e;return r&&(i.setAttribute("href",t),t=i.href),i.setAttribute("href",t),{href:i.href,protocol:i.protocol?i.protocol.replace(/:$/,""):"",host:i.host,search:i.search?i.search.replace(/^\?/,""):"",hash:i.hash?i.hash.replace(/^#/,""):"",hostname:i.hostname,port:i.port,pathname:"/"===i.pathname.charAt(0)?i.pathname:"/"+i.pathname}}var o,r=/(msie|trident)/i.test(navigator.userAgent),i=document.createElement("a");return o=n(window.location.href),function(e){var t=c.isString(e)?n(e):e;return t.protocol===o.protocol&&t.host===o.host}}():function(){return!0}},function(e,t){function a(){this.message="String contains an invalid character"}var s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";(a.prototype=new Error).code=5,a.prototype.name="InvalidCharacterError",e.exports=function(e){for(var t,n,o=String(e),r="",i=0,c=s;o.charAt(0|i)||(c="=",i%1);r+=c.charAt(63&t>>8-i%1*8)){if(255<(n=o.charCodeAt(i+=.75)))throw new a;t=t<<8|n}return r}},function(e,t,n){var a=n(2);e.exports=a.isStandardBrowserEnv()?{write:function(e,t,n,o,r,i){var c=[];c.push(e+"="+encodeURIComponent(t)),a.isNumber(n)&&c.push("expires="+new Date(n).toGMTString()),a.isString(o)&&c.push("path="+o),a.isString(r)&&c.push("domain="+r),!0===i&&c.push("secure"),document.cookie=c.join("; ")},read:function(e){var t=document.cookie.match(new RegExp("(^|;\\s*)("+e+")=([^;]*)"));return t?decodeURIComponent(t[3]):null},remove:function(e){this.write(e,"",Date.now()-864e5)}}:{write:function(){},read:function(){return null},remove:function(){}}},function(e,t,n){function o(){this.handlers=[]}var r=n(2);o.prototype.use=function(e,t){return this.handlers.push({fulfilled:e,rejected:t}),this.handlers.length-1},o.prototype.eject=function(e){this.handlers[e]&&(this.handlers[e]=null)},o.prototype.forEach=function(t){r.forEach(this.handlers,function(e){null!==e&&t(e)})},e.exports=o},function(e,t,n){function o(e){e.cancelToken&&e.cancelToken.throwIfRequested()}var r=n(2),i=n(19),c=n(20),a=n(6),s=n(21),u=n(22);e.exports=function(t){return o(t),t.baseURL&&!s(t.url)&&(t.url=u(t.baseURL,t.url)),t.headers=t.headers||{},t.data=i(t.data,t.headers,t.transformRequest),t.headers=r.merge(t.headers.common||{},t.headers[t.method]||{},t.headers||{}),r.forEach(["delete","get","head","post","put","patch","common"],function(e){delete t.headers[e]}),(t.adapter||a.adapter)(t).then(function(e){return o(t),e.data=i(e.data,e.headers,t.transformResponse),e},function(e){return c(e)||(o(t),e&&e.response&&(e.response.data=i(e.response.data,e.response.headers,t.transformResponse))),Promise.reject(e)})}},function(e,t,n){var o=n(2);e.exports=function(t,n,e){return o.forEach(e,function(e){t=e(t,n)}),t}},function(e,t){e.exports=function(e){return!(!e||!e.__CANCEL__)}},function(e,t){e.exports=function(e){return/^([a-z][a-z\d\+\-\.]*:)?\/\//i.test(e)}},function(e,t){e.exports=function(e,t){return t?e.replace(/\/+$/,"")+"/"+t.replace(/^\/+/,""):e}},function(e,t){function n(e){this.message=e}n.prototype.toString=function(){return"Cancel"+(this.message?": "+this.message:"")},n.prototype.__CANCEL__=!0,e.exports=n},function(e,t,n){function o(e){if("function"!=typeof e)throw new TypeError("executor must be a function.");var t;this.promise=new Promise(function(e){t=e});var n=this;e(function(e){n.reason||(n.reason=new r(e),t(n.reason))})}var r=n(23);o.prototype.throwIfRequested=function(){if(this.reason)throw this.reason},o.source=function(){var t;return{token:new o(function(e){t=e}),cancel:t}},e.exports=o},function(e,t){e.exports=function(t){return function(e){return t.apply(null,e)}}}])},"object"==((e=void 0)===o?"undefined":l(o))&&"object"==(void 0===n?"undefined":l(n))?n.exports=t():"function"==typeof define&&define.amd?define([],t):"object"==(void 0===o?"undefined":l(o))?o.axios=t():e.axios=t(),cc._RF.pop()}).call(this,e("_process"))},{_process:1}],car_long:[function(e,t,n){"use strict";cc._RF.push(t,"0c52feG9NtDBrMIqQNwTxQf","car_long"),cc.Class({extends:cc.Component,properties:{},start:function(){var e=this;this.scheduleOnce(function(){e.node.runAction(cc.rotateBy(30,2e5))},1)},onDestroy:function(){this.unscheduleAllCallbacks()}}),cc._RF.pop()},{}],common:[function(e,t,n){"use strict";cc._RF.push(t,"4c8eaLwdYhCOoTXrA4dLKJu","common");var o={url:"http://39.106.221.125:8080",ge:{resultRange:100,racingRange:100,champion:-300},cycle:120,random:function(e,t){var n=t-e;return e+Math.round(Math.random()*n)},lastScene:null};t.exports=o,cc._RF.pop()},{}],fit:[function(e,t,n){"use strict";cc._RF.push(t,"88b9bjFRidOBrjNBYOlYceT","fit"),cc.Class({extends:cc.Component,properties:{},onLoad:function(){cc.view.setDesignResolutionSize(640,960,cc.ResolutionPolicy.EXACT_FIT)},start:function(){}}),cc._RF.pop()},{}],hall:[function(e,t,n){"use strict";cc._RF.push(t,"e6e21POS31C67xnNmPZoWet","hall");var i=e("request"),c=e("common");cc.Class({extends:cc.Component,properties:{rangkingBtn:{type:cc.Node,default:null},methods:{type:cc.Node,default:null},hallContentBack:{type:cc.Node,default:null},bottom:{type:cc.Node,default:null},timer_label:{type:cc.Label,default:null},menuBtn:{type:cc.Node,default:null},userBox:{type:cc.Node,default:null},tip:{type:cc.Node,default:null},ranking:{type:cc.Node,default:null}},onLoad:function(){var o=this;if(this._status=!0,i({url:"/wxmp/racing/user/"+c.user.userUuid,method:"get"}).then(function(e){o.num.string=e.data.coins}),"login"==c.lastScene);else if("race"==c.lastScene){var e=cc.moveBy(.5,0,-765);this.ranking.runAction(e)}i({url:"/wxmp/racing/match/1",method:"get"}).then(function(e){for(var t in o.time=e.data.countDown/1e3||0,console.log("time",o.time),o.timer_label.string=parseInt(o.time)||0,c.info={},e.data)e.data.hasOwnProperty(t)&&(c.info[t]=e.data[t]);c.currentResult=e.data.history[0].resultDetail.map(function(e){return e+1}),c.historyResult=[],e.data.history.forEach(function(e){c.historyResult.push(e.resultDetail.map(function(e){return e+1}).join(" "))}),cc.find("p1/label",o.ranking).getComponent("cc.Label").string=c.currentResult[0],cc.find("ranking_back/ranking",o.ranking).children.forEach(function(e,t){cc.find("label",e).getComponent("cc.Label").string=c.historyResult[t]||""})});var r=100;c.tempAdd={},this.addBtn=cc.find("numbottom/add",this.bottom),this.num=cc.find("numbottom/label",this.bottom).getComponent("cc.Label"),this.addBtn.on(cc.Node.EventType.TOUCH_END,function(e){this.tip.active=!0},this),this.options=cc.find("btns",this.bottom),this.options.children.forEach(function(t){t.on(cc.Node.EventType.TOUCH_END,function(e){switch(this.options.children.forEach(function(e){cc.find("active",e).active=!1}),cc.find("active",t).active=!0,cc.find("label",t).getComponent("cc.Label").string){case"100":r=100;break;case"1000":r=1e3;break;case"1万":r=1e4}},o)}),this.methods.children.forEach(function(t){t.on(cc.Node.EventType.TOUCH_END,function(e){this.methods.children.forEach(function(e){cc.find("method_active",e).active=!1}),cc.find("method_active",t).active=!0},o)}),this.hallContentBack.children.forEach(function(n){c.tempAdd[n.name]=0,n.on(cc.Node.EventType.TOUCH_END,function(e){var t=cc.find("layout/mine/label",n).getComponent("cc.Label");e.stopPropagation(),1*this.num.string>=r?(t.string=1*t.string+r,this.num.string=1*this.num.string-r,c.tempAdd[n.name]+=r):console.log("余额不足, 请充值")},o)}),this.del=cc.find("del",this.bottom),this.del.on(cc.Node.EventType.TOUCH_END,function(e){this.hallContentBack.children.forEach(function(e,t){cc.find("layout/all/label",e).getComponent("cc.Label");var n=cc.find("layout/mine/label",e).getComponent("cc.Label");n.string=1*n.string-c.tempAdd[e.name]});var t=0;for(var n in c.tempAdd)c.tempAdd.hasOwnProperty(n)&&(t+=c.tempAdd[n],c.tempAdd[n]=0);this.num.string=1*this.num.string+t},this),cc.find("mask",this.tip).on(cc.Node.EventType.TOUCH_END,function(e){},this),cc.find("webView/close",this.tip).on(cc.Node.EventType.TOUCH_END,function(e){cc.find("webView",this.tip).active=!1,this.tip.active=!1},this),cc.find("dialog/confirm",this.tip).on(cc.Node.EventType.TOUCH_END,function(e){cc.find("webView",this.tip).active=!0,cc.find("webView",this.tip).getComponent("cc.WebView").url="https://m.baidu.com"},this),cc.find("dialog/cancel",this.tip).on(cc.Node.EventType.TOUCH_END,function(e){this.tip.active=!1},this),this.rangkingBtn.on(cc.Node.EventType.TOUCH_END,function(e){var t=cc.moveBy(.5,0,-765);this.ranking.runAction(t)},this),cc.find("up",this.ranking).on(cc.Node.EventType.TOUCH_END,function(e){var t=cc.moveBy(.5,0,765);this.ranking.runAction(t)},this)},start:function(){},update:function(e){if(this.time&&this._status&&(this.time-=e,this.timer_label.string=parseInt(this.time),this.time<=.5)){this._status=!1;var t=[];for(var n in c.tempAdd)if(c.tempAdd.hasOwnProperty(n)){var o=1*n.replace("car_panel","")-1;0<c.tempAdd[n]&&t.push({amount:c.tempAdd[n],wins:o+""})}console.log({userUuid:c.user.userUuid,accountUuid:c.user.accountUuid,matchUuid:c.info.current.matchResultUuid,details:t}),c.lastScene="hall",cc.director.loadScene("race",function(){i({url:"/wxmp/racing/coins/"+c.user.userUuid,method:"post",data:{userUuid:c.user.userUuid,accountUuid:c.user.accountUuid,matchUuid:c.info.current.matchResultUuid,details:t},headers:{"Content-Type":"application/json"}})})}},onDestroy:function(){this.unscheduleAllCallbacks()}}),cc._RF.pop()},{common:"common",request:"request"}],login:[function(e,t,n){"use strict";cc._RF.push(t,"33a866OvilFBqyam1BQb1/7","login");var o=e("common"),c=e("request");cc.Class({extends:cc.Component,properties:{loginBtn:{type:cc.Node,default:null},registerBtn:{type:cc.Node,default:null},initPanel:{type:cc.Node,default:null},registerPanel:{type:cc.Node,default:null},loginPanel:{type:cc.Node,default:null},goBack:{type:cc.Node,default:null},code_btn:{type:cc.Node,default:null},register_operation:{type:cc.Node,default:null},login_operation:{type:cc.Node,default:null}},onLoad:function(){this.loginBtn.on(cc.Node.EventType.TOUCH_END,function(e){this.initPanel.active=!1,this.loginPanel.active=!0},this),this.registerBtn.on(cc.Node.EventType.TOUCH_END,function(e){this.initPanel.active=!1,this.registerPanel.active=!0},this),this.goBack.on(cc.Node.EventType.TOUCH_END,function(e){this.initPanel.active=!0,this.registerPanel.active=!1,this.loginPanel.active=!1},this),this.code_btn.on(cc.Node.EventType.TOUCH_END,function(e){var t=cc.find("phone/inputNum",this.registerPanel).getComponent("cc.EditBox").string;t?c.get("/wxmp/racing/createCode/"+t).then(function(e){}):!t&&console.log("手机号没填")},this),this.register_operation.on(cc.Node.EventType.TOUCH_END,function(e){var t=this,n=cc.find("phone/inputNum",this.registerPanel).getComponent("cc.EditBox").string,o=cc.find("inputCode",this.registerPanel).getComponent("cc.EditBox").string,r=cc.find("inputName",this.registerPanel).getComponent("cc.EditBox").string,i=cc.find("inputPassword",this.registerPanel).getComponent("cc.EditBox").string;n&&o&&i?c({url:"/wxmp/racing/bindMobile?code="+o,method:"post",data:{code:o,mobile:n,userNickName:r,openId:"",pwd:i},headers:{"Content-Type":"application/json"}}).then(function(e){"SUCCESS"==e.error.errorMsg&&(console.log("注册成功"),t.initPanel.active=!1,t.registerPanel.active=!1,t.loginPanel.active=!0)}):(!n&&console.log("手机号没填"),!o&&console.log("验证码没填"),!i&&console.log("密码没填"))},this),this.login_operation.on(cc.Node.EventType.TOUCH_END,function(e){var t=cc.find("inputNum",this.loginPanel).getComponent("cc.EditBox").string,n=cc.find("inputPassword",this.loginPanel).getComponent("cc.EditBox").string;t&&n?c({url:"/wxmp/racing/login",method:"post",data:{mobile:t,openId:"",pwd:n},headers:{"Content-Type":"application/json"}}).then(function(e){for(var t in o.user={},e.data)e.data.hasOwnProperty(t)&&(o.user[t]=e.data[t]);var n=0;c({url:"/wxmp/racing/match/1",method:"get"}).then(function(e){n=Math.round(e.data.countDown/1e3),console.log("time",n),o.lastScene="login",n>=o.cycle-35||n<=3?cc.director.loadScene("race"):cc.director.loadScene("hall")})}):(!t&&console.log("手机号没填"),!n&&console.log("密码没填"))},this)},start:function(){}}),cc._RF.pop()},{common:"common",request:"request"}],race:[function(e,t,n){"use strict";cc._RF.push(t,"49cab5zf5FAAZ5XAJx2OAnu","race");var s=e("common"),i=e("request");cc.Class({extends:cc.Component,properties:{track:{default:null,type:cc.Node},car1:{default:null,type:cc.Node},car2:{default:null,type:cc.Node},car3:{default:null,type:cc.Node},car4:{default:null,type:cc.Node},car5:{default:null,type:cc.Node},car6:{default:null,type:cc.Node},screenshot:{default:null,type:cc.Node},mask:{default:null,type:cc.Node},canvas:{default:null,type:cc.Node},timeout_label:{default:null,type:cc.Node},count:{default:null,type:cc.Node}},geCarAction:function(e){var t=[];return e.forEach(function(e){t.push(cc.moveBy(1,e,0))}),cc.sequence(t)},_screenshot:function(e,n,o){var r=this;this.scheduleOnce(function(){var e=cc.RenderTexture.create(640,750);e.begin(),r.canvas._sgNode.visit(),e.end(),n._sgNode.addChild(e,9999);var t=cc.rotateBy(0,30);n.runAction(t),o.active=!0,r._status=!1,r.scheduleOnce(function(){s.lastScene="race",cc.director.loadScene("hall",function(){console.log("race时间[test]",(new Date).valueOf()-r.test)})},1)},e)},onLoad:function(){this.test=(new Date).valueOf(),this._status=!1,this._timeout_label=this.timeout_label.getComponent(cc.Label),this._count_label=this.count.getComponent(cc.Label),this.time=0},start:function(){var n=this,o=!1,e=0;function r(e){var t=null,n={},o=0,r={};for(var i in s.currentResult.forEach(function(e,t){n["car"+e]=0==t?-300:o+s.random(0,s.ge.resultRange),o=n["car"+e]}),console.log(s.currentResult,n),n)if(n.hasOwnProperty(i)){r[i]=[];for(var c=1;c<=30-e.time-1;c++){if(c==30-e.time-1){var a=r[i].reduce(function(e,t){return e+t});r[i].push(n[i]-a);break}r[i].push(s.random(-s.ge.racingRange,s.ge.racingRange))}}for(var i in t="hall"==s.lastScene?cc.sequence(cc.moveBy(.5,848,0),cc.repeat(cc.sequence(cc.moveBy(.5,928,0),cc.moveBy(0,-928,0)),56),cc.moveBy(1,1790,0)):cc.sequence(cc.moveBy(0,848,0),cc.repeat(cc.sequence(cc.moveBy(.5,928,0),cc.moveBy(0,-928,0)),2*(30-e.time-1)),cc.moveBy(1,1790,0)),e.track.runAction(t),console.log(r),r)r.hasOwnProperty(i)&&e[i].runAction(e.geCarAction(r[i]));e._screenshot(30-e.time,e.screenshot,e.mask)}"hall"==s.lastScene?(e=2,this.schedule(function(){n._count_label.string=1*n._count_label.string-1,0==n._count_label.string&&n.scheduleOnce(function(){n.count.active=!1,n.mask.active=!1,n._status=!0,o?r(n):console.log("接口2s没返回")},1)},1,3,0)):"login"==s.lastScene&&(this.count.active=!1,this.mask.active=!1,this._status=!0),this.schedule(function(){i({method:"get",url:"/wxmp/racing/match/1"}).then(function(e){for(var t in s.info={},e.data)e.data.hasOwnProperty(t)&&(s.info[t]=e.data[t]);"hall"==s.lastScene?n.time=0:(n.time=s.cycle-Math.round(s.info.countDown/1e3),30<n.time&&(n.time=0)),console.log("time",s.info.countDown/1e3),o=!0,s.currentResult=e.data.history[0].resultDetail.map(function(e){return e+1}),"login"==s.lastScene&&r(n)})},0,0,e)},update:function(e){this._status&&this._timeout_label.string&&(this.time+=e,this._timeout_label.string=this.time.toFixed(2))},onDestroy:function(){this.unscheduleAllCallbacks()}}),cc._RF.pop()},{common:"common",request:"request"}],request:[function(e,t,n){"use strict";cc._RF.push(t,"5a44eaTFC1Ir6RC9n4HDiYp","request");var o=e("axios"),r=e("common"),i=o.create({baseURL:r.url,timeout:2e3});i.interceptors.request.use(function(e){return e},function(e){return Promise.reject(e)}),i.interceptors.response.use(function(e){switch(e.data.error.error){case 0:return console.log("请求成功"),e.data;case 9999:console.log(e),console.log("请求失败");break;case 500:console.log(e),console.log("服务器异常");break;case 1001:console.log(e),console.log("参数异常");break;case 1002:console.log(e),console.log("用户账户异常")}},function(e){return Promise.reject(e)}),t.exports=i,cc._RF.pop()},{axios:"axios",common:"common"}]},{},["common","fit","hall","axios","request","login","car_long","race"]);