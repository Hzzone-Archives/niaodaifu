--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: dachuang; Type: DATABASE; Schema: -; Owner: hzzone
--

CREATE DATABASE dachuang WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE dachuang OWNER TO hzzone;

\connect dachuang

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: address; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.address (
    address_id character varying(1000) NOT NULL,
    province character varying(1000) NOT NULL,
    city character varying(1000) NOT NULL,
    area character varying(1000) NOT NULL,
    address_detail character varying(1000) NOT NULL,
    user_name character varying(1000) NOT NULL,
    phone_number character varying(1000) NOT NULL,
    openid character varying(1000) NOT NULL
);


ALTER TABLE public.address OWNER TO hzzone;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.cart (
    open_id character varying(1000) NOT NULL,
    product_id character varying(1000) NOT NULL,
    counts integer
);


ALTER TABLE public.cart OWNER TO hzzone;

--
-- Name: comment; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.comment (
    comment_id character varying(1000) NOT NULL,
    post_id character varying(1000),
    from_openid character varying(1000),
    to_openid character varying(1000),
    comment_content character varying(1000),
    comment_time timestamp without time zone
);


ALTER TABLE public.comment OWNER TO hzzone;

--
-- Name: completed_order; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.completed_order (
    order_id character varying(1000) NOT NULL,
    open_id character varying(1000) NOT NULL
);


ALTER TABLE public.completed_order OWNER TO hzzone;

--
-- Name: hot_keywords; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.hot_keywords (
    keywords_id character varying(1000) NOT NULL,
    keywords character varying(1000)
);


ALTER TABLE public.hot_keywords OWNER TO hzzone;

--
-- Name: hot_product; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.hot_product (
    product_id character varying(1000) NOT NULL
);


ALTER TABLE public.hot_product OWNER TO hzzone;

--
-- Name: new_product; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.new_product (
    product_id character varying(1000) NOT NULL
);


ALTER TABLE public.new_product OWNER TO hzzone;

--
-- Name: notification; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.notification (
    notification_id character varying(1000) NOT NULL,
    from_openid character varying(1000),
    to_openid character varying(1000),
    post_content character varying(10000)
);


ALTER TABLE public.notification OWNER TO hzzone;

--
-- Name: order_item; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.order_item (
    order_id character varying(1000),
    product_id character varying(1000),
    price double precision,
    counts integer
);


ALTER TABLE public.order_item OWNER TO hzzone;

--
-- Name: post; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.post (
    post_id character varying(1000) NOT NULL,
    post_time timestamp without time zone,
    post_content character varying(10000),
    title character varying(1000),
    open_id character varying(1000)
);


ALTER TABLE public.post OWNER TO hzzone;

--
-- Name: product; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.product (
    product_id character varying(1000) NOT NULL,
    product_name character varying(1000),
    price double precision DEFAULT 100.0
);


ALTER TABLE public.product OWNER TO hzzone;

--
-- Name: product_intro_images; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.product_intro_images (
    product_id character varying(1000) NOT NULL,
    url character varying(1000) NOT NULL
);


ALTER TABLE public.product_intro_images OWNER TO hzzone;

--
-- Name: product_simple_images; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.product_simple_images (
    product_id character varying(1000) NOT NULL,
    url character varying(1000) NOT NULL
);


ALTER TABLE public.product_simple_images OWNER TO hzzone;

--
-- Name: records; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.records (
    records_id character varying(1000) NOT NULL,
    open_id character varying(1000),
    record_type character varying(1000),
    records_time timestamp without time zone
);


ALTER TABLE public.records OWNER TO hzzone;

--
-- Name: records_item; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.records_item (
    records_id character varying(1000) NOT NULL,
    item_type character varying(1000) NOT NULL,
    item_info character varying(1000) NOT NULL
);


ALTER TABLE public.records_item OWNER TO hzzone;

--
-- Name: shop_order; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.shop_order (
    open_id character varying(1000),
    order_time timestamp without time zone,
    order_id character varying(1000) NOT NULL,
    address_id character varying(1000) NOT NULL
);


ALTER TABLE public.shop_order OWNER TO hzzone;

--
-- Name: support; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.support (
    support_id character varying(1000) NOT NULL,
    open_id character varying(1000) NOT NULL
);


ALTER TABLE public.support OWNER TO hzzone;

--
-- Name: tocomplete_order; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.tocomplete_order (
    order_id character varying(1000) NOT NULL,
    open_id character varying(1000) NOT NULL
);


ALTER TABLE public.tocomplete_order OWNER TO hzzone;

--
-- Name: users; Type: TABLE; Schema: public; Owner: hzzone
--

CREATE TABLE public.users (
    open_id character varying(1000) NOT NULL,
    user_name character varying(1000) NOT NULL,
    session_key character varying(1000),
    user_img character varying(1000),
    birthday date,
    phone_number character varying(1000),
    sex boolean DEFAULT true,
    province character varying(1000),
    city character varying(1000),
    country character varying(1000),
    user_language character varying(1000)
);


ALTER TABLE public.users OWNER TO hzzone;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.address (address_id, province, city, area, address_detail, user_name, phone_number, openid) FROM stdin;
28b88073-c5fc-4fb5-badf-58b34c8d0f7d	湖北省	湖北省	湖北省	四川大学江安校区西南门	黄智忠	17721876903	oVL684iOhwDmAR70giu2EgCjBWrE
\.


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.cart (open_id, product_id, counts) FROM stdin;
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.comment (comment_id, post_id, from_openid, to_openid, comment_content, comment_time) FROM stdin;
52a32baa-b0b3-49f3-b0d0-7b5f234347da	6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE		哈哈哈哈哈哈哈哈哈哈哈哈哈这是一个测试内容	2018-04-10 01:13:47.359
78fcac54-ab03-4822-a3ed-c50b3047f5c3	6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE	oVL684iOhwDmAR70giu2EgCjBWrE	@.:\n哈哈哈哈哈哈哈	2018-04-10 18:27:40.589
619dd058-f94f-4fac-a905-deaed6a10bec	e57fa1a5-3b72-4aa8-98c1-f7ff423655ec	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	aaaaaaaaaaaaaaa	2018-04-10 18:28:58.112
3039bb76-0469-4a88-bb1d-819b81f5c949	e57fa1a5-3b72-4aa8-98c1-f7ff423655ec	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	ha h ha h ha哈哈哈哈哈哈哈	2018-04-10 18:30:17.16
3a8a530c-0dec-4b4a-8ceb-3537ebf96e6f	e57fa1a5-3b72-4aa8-98c1-f7ff423655ec	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	妈的	2018-04-10 18:31:22.631
4bd3205e-aa76-4367-a97c-e0f8c9ab9636	6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE	oVL684iOhwDmAR70giu2EgCjBWrE	what the fuck	2018-04-10 18:32:16.53
7399172a-95c2-42c4-b105-021b8fa5d0db	d8cfc658-05d5-46aa-8928-f2d3c90523fd	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	好爱好爱小熊啊	2018-04-10 20:14:02.892
e82b0542-2554-4dc6-932a-739b7ff9cf08	6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE	oVL684iOhwDmAR70giu2EgCjBWrE	hhhhhhh	2018-04-10 20:15:16.142
3efb79de-859a-46ce-9d90-695349674528	6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	emmmmm	2018-04-19 10:20:58.364
85d856fb-b504-4f64-9077-2cb034c5c387	10c46a58-d26c-4ff9-9c6e-bca7621a6521	oVL684iOhwDmAR70giu2EgCjBWrE	undefined	emmmm	2018-04-19 10:21:19.349
8232703a-ff63-4f02-9ac6-11cce7c90f2e	10c46a58-d26c-4ff9-9c6e-bca7621a6521	oVL684iOhwDmAR70giu2EgCjBWrE	oVL684iOhwDmAR70giu2EgCjBWrE	卧槽	2018-04-19 10:21:27.317
\.


--
-- Data for Name: completed_order; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.completed_order (order_id, open_id) FROM stdin;
6f28d5d5-489d-4772-8275-57dc7dcb556c	oVL684iOhwDmAR70giu2EgCjBWrE
\.


--
-- Data for Name: hot_keywords; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.hot_keywords (keywords_id, keywords) FROM stdin;
\.


--
-- Data for Name: hot_product; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.hot_product (product_id) FROM stdin;
2
3
4
5
\.


--
-- Data for Name: new_product; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.new_product (product_id) FROM stdin;
1
2
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.notification (notification_id, from_openid, to_openid, post_content) FROM stdin;
\.


--
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.order_item (order_id, product_id, price, counts) FROM stdin;
6f28d5d5-489d-4772-8275-57dc7dcb556c	1	100	1
2	1	100	2
f96d9927-6130-4179-9845-18b5b598dfa7	1	200	3
f96d9927-6130-4179-9845-18b5b598dfa7	2	188.099999999999994	2
79dfe6ae-4f3b-4e51-ba08-010a31696684	1	200	3
79dfe6ae-4f3b-4e51-ba08-010a31696684	2	188.099999999999994	2
180a3d63-0440-4120-983f-d046cabe9716	1	200	3
180a3d63-0440-4120-983f-d046cabe9716	2	188.099999999999994	2
34f0ab5b-996d-48b8-abf4-e2a9c33d236a	1	200	3
34f0ab5b-996d-48b8-abf4-e2a9c33d236a	2	188.099999999999994	2
48b319b2-df9e-40c2-b77f-28b039fc8403	1	200	1
bd816d0d-54fd-49f1-bd5c-1ee8b34b0212	1	200	1
bf0e222d-2a03-42b2-b568-d562600b7124	2	188.099999999999994	1
\.


--
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.post (post_id, post_time, post_content, title, open_id) FROM stdin;
6e451d10-d60e-4791-b748-7a65647a1438	2018-04-10 01:05:58.214	哈哈哈哈哈哈哈哈哈哈哈哈哈这是一个测试内容	测试一下嘿嘿	oVL684iOhwDmAR70giu2EgCjBWrE
e57fa1a5-3b72-4aa8-98c1-f7ff423655ec	2018-04-10 01:41:45.697	哈哈哈哈哈哈哈哈哈哈哈哈哈这是一个测试内容	测试一下嘿嘿	oVL684iOhwDmAR70giu2EgCjBWrE
d8cfc658-05d5-46aa-8928-f2d3c90523fd	2018-04-10 20:13:45.1	这是一个测试内容哈哈哈哈哈哈，完成了讨论区的所有功能	我爱小熊	oVL684iOhwDmAR70giu2EgCjBWrE
10c46a58-d26c-4ff9-9c6e-bca7621a6521	2018-04-19 10:21:12.073	哈哈哈哈哈哈哈哈	我擦	oVL684iOhwDmAR70giu2EgCjBWrE
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.product (product_id, product_name, price) FROM stdin;
1	青鱼蓝ph试纸精密酸碱度测试水质化妆品试纸鱼缸水族酵素唾液尿液	200
2	强生稳豪型血糖仪试纸25/50/100片血糖试纸条倍易倍优测试仪家用	188.099999999999994
3	尿液分析仪 尿常规检测仪 尿机 赠送尿试条一桶 优利特URIT180	400
4	尿常规14项检测尿液目测分析试纸尿蛋白肌酐亚硝酸盐试纸送尿杯管	267
5	艾康尿十项尿液检测试纸条mission 尿试纸 尿酮体 蛋白 尿糖PH	178.009999999999991
6	智能检测14项尿大夫试纸尿蛋白隐血酮体微量白蛋白肌酐尿液试条	126.099999999999994
\.


--
-- Data for Name: product_intro_images; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.product_intro_images (product_id, url) FROM stdin;
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2qkLvmSBjpuFjy1XdXXaooVXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2fDcyaHD8F1Jjy0FpXXcduVXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2eDAjmS0jpuFjy0FlXXc0bpXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2cNn5mR0kpuFjy1zdXXXuUVXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2CaY2mStkpuFjy0FhXXXQzFXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2B1ctmR0kpuFjSsppXXcGTXXa_--2070416882.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2rRHLmbsTMeJjSszgXXacpFXa_--114774010.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2mkOPijuhSKJjSspjXXci8VXa_--114774009.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2Lt2uhLBNTKJjSszcXXbO2VXa_--114774009.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2.xXPjaagSKJjy0FbXXa.mVXa_--114774009.png
3	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2tZ9ljLDH8KJjy1XcXXcpdXXa_--3398373063.jpg
3	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2tZ9ljLDH8KJjy1XcXXcpdXXa_--3398373062%203.jpg
3	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2tZ9ljLDH8KJjy1XcXXcpdXXa_--3398373062%202.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2YfjEanqWBKNjSZFAXXanSpXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2R5fAacuYBuNkSmRyXXcA3pXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2LtrpaiMnBKNjSZFzXXc_qVXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2jHTJcb5YBuNjSspoXXbeNFXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2fKiSaf6TBKNjSZJiXXbKVFXa_--2009799359.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2oH45qwxlpuFjy0FoXXa.lXXa_--272597219.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2lwsBqmxjpuFjSszeXXaeMVXa_--272597218%20-1-.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2CKpfqrFkpuFjy1XcXXclapXa_--272597219.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2zrc7XXOWBuNjy0FiXXXFxVXa_--30409611.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2Qoc9XeySBuNjy1zdXXXPxFXa_--30409611.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2EGeNXDlYBeNjSszcXXbwhFXa_--30409611.jpg
\.


--
-- Data for Name: product_simple_images; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.product_simple_images (product_id, url) FROM stdin;
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB24D1yayefF1JjSspmXXcGeXXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2uQ9FbC_9F1JjSZFhXXbadVXa_--2070416882.jpg
1	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2DrSxaEyfF1Jjy0FiXXaCmFXa_--2070416882.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB29KxilNOMSKJjSZFlXXXqQFXa_--114774009.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2Y0W6ivNNTKJjSspkXXaeWFXa_--114774009.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2rRHLmbsTMeJjSszgXXacpFXa_--114774009.jpg
2	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2.5RphVuWBuNjSspnXXX1NVXa_--114774009.jpg
3	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2tZ9ljLDH8KJjy1XcXXcpdXXa_--3398373062.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2y86talyWBuNkSmFPXXXguVXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2ptrOg9tYBeNjSspaXXaOOFXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2NVTkaljTBKNjSZFDXXbVgVXa_--2009799359.jpg
4	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2LcvgcbSYBuNjSspiXXXNzpXa_--2009799359.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2oH45qwxlpuFjy0FoXXa.lXXa_--272597218.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2lwsBqmxjpuFjSszeXXaeMVXa_--272597218.jpg
5	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2CKpfqrFkpuFjy1XcXXclapXa_--272597218.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2YwQ6XXGWBuNjy0FbXXb4sXXa_--30409611.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2scupXxSYBuNjSspjXXX73VXa_--30409611.jpg
6	http://tuchuang-1252747889.cosgz.myqcloud.com/2018-04-05-TB2JapgdFuWBuNjSszbXXcS7FXa_--30409611.jpg
\.


--
-- Data for Name: records; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.records (records_id, open_id, record_type, records_time) FROM stdin;
\.


--
-- Data for Name: records_item; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.records_item (records_id, item_type, item_info) FROM stdin;
\.


--
-- Data for Name: shop_order; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.shop_order (open_id, order_time, order_id, address_id) FROM stdin;
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-08 14:08:00.282	6f28d5d5-489d-4772-8275-57dc7dcb556c	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-08 13:12:17.264	2	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-09 01:09:17.681	f96d9927-6130-4179-9845-18b5b598dfa7	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-09 01:17:31.281	79dfe6ae-4f3b-4e51-ba08-010a31696684	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-09 19:07:16.657	180a3d63-0440-4120-983f-d046cabe9716	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-09 19:16:08.402	34f0ab5b-996d-48b8-abf4-e2a9c33d236a	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-15 15:10:34.759	48b319b2-df9e-40c2-b77f-28b039fc8403	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-19 10:19:17.429	bd816d0d-54fd-49f1-bd5c-1ee8b34b0212	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
oVL684iOhwDmAR70giu2EgCjBWrE	2018-04-19 10:20:23.506	bf0e222d-2a03-42b2-b568-d562600b7124	28b88073-c5fc-4fb5-badf-58b34c8d0f7d
\.


--
-- Data for Name: support; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.support (support_id, open_id) FROM stdin;
6e451d10-d60e-4791-b748-7a65647a1438	oVL684iOhwDmAR70giu2EgCjBWrE
52a32baa-b0b3-49f3-b0d0-7b5f234347da	oVL684iOhwDmAR70giu2EgCjBWrE
3a8a530c-0dec-4b4a-8ceb-3537ebf96e6f	oVL684iOhwDmAR70giu2EgCjBWrE
3039bb76-0469-4a88-bb1d-819b81f5c949	oVL684iOhwDmAR70giu2EgCjBWrE
4bd3205e-aa76-4367-a97c-e0f8c9ab9636	oVL684iOhwDmAR70giu2EgCjBWrE
e57fa1a5-3b72-4aa8-98c1-f7ff423655ec	oVL684iOhwDmAR70giu2EgCjBWrE
10c46a58-d26c-4ff9-9c6e-bca7621a6521	oVL684iOhwDmAR70giu2EgCjBWrE
85d856fb-b504-4f64-9077-2cb034c5c387	oVL684iOhwDmAR70giu2EgCjBWrE
\.


--
-- Data for Name: tocomplete_order; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.tocomplete_order (order_id, open_id) FROM stdin;
2	oVL684iOhwDmAR70giu2EgCjBWrE
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: hzzone
--

COPY public.users (open_id, user_name, session_key, user_img, birthday, phone_number, sex, province, city, country, user_language) FROM stdin;
oVL684iOhwDmAR70giu2EgCjBWrE	.	NrVFFn2ewbYagkegi96x+w==	https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ40OxuL7aV0csyVfrgApStaaxicg9Zs0p7YalHuevLkuWfxjTibZ0SbB6LPVKJcCKDuZWVatbSxwyg/0	\N	\N	t	Sichuan	Chengdu	China	zh_CN
\.


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (open_id, product_id);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);


--
-- Name: completed_order completed_order_openid_pk; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.completed_order
    ADD CONSTRAINT completed_order_openid_pk PRIMARY KEY (open_id, order_id);


--
-- Name: hot_keywords hot_keywords_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.hot_keywords
    ADD CONSTRAINT hot_keywords_pkey PRIMARY KEY (keywords_id);


--
-- Name: hot_product hot_product_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.hot_product
    ADD CONSTRAINT hot_product_pkey PRIMARY KEY (product_id);


--
-- Name: new_product new_product_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.new_product
    ADD CONSTRAINT new_product_pkey PRIMARY KEY (product_id);


--
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (notification_id);


--
-- Name: shop_order order_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.shop_order
    ADD CONSTRAINT order_pkey PRIMARY KEY (order_id);


--
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (post_id);


--
-- Name: product_intro_images product_intro_images_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.product_intro_images
    ADD CONSTRAINT product_intro_images_pkey PRIMARY KEY (product_id, url);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- Name: product_simple_images product_simple_images_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.product_simple_images
    ADD CONSTRAINT product_simple_images_pkey PRIMARY KEY (product_id, url);


--
-- Name: records_item records_item_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.records_item
    ADD CONSTRAINT records_item_pkey PRIMARY KEY (item_info, item_type, records_id);


--
-- Name: records records_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT records_pkey PRIMARY KEY (records_id);


--
-- Name: support support_open_id_pk; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.support
    ADD CONSTRAINT support_open_id_pk PRIMARY KEY (open_id, support_id);


--
-- Name: tocomplete_order tocomplete_order_open_id_pk; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.tocomplete_order
    ADD CONSTRAINT tocomplete_order_open_id_pk PRIMARY KEY (open_id, order_id);


--
-- Name: users user_pkey; Type: CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (open_id);


--
-- Name: address_address_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX address_address_id_uindex ON public.address USING btree (address_id);


--
-- Name: comment_comment_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX comment_comment_id_uindex ON public.comment USING btree (comment_id);


--
-- Name: completed_order_order_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX completed_order_order_id_uindex ON public.completed_order USING btree (order_id);


--
-- Name: notification_notification_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX notification_notification_id_uindex ON public.notification USING btree (notification_id);


--
-- Name: order_order_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX order_order_id_uindex ON public.shop_order USING btree (order_id);


--
-- Name: post_post_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX post_post_id_uindex ON public.post USING btree (post_id);


--
-- Name: product_product_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX product_product_id_uindex ON public.product USING btree (product_id);


--
-- Name: records_records_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX records_records_id_uindex ON public.records USING btree (records_id);


--
-- Name: support_support_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX support_support_id_uindex ON public.support USING btree (support_id);


--
-- Name: user_open_id_uindex; Type: INDEX; Schema: public; Owner: hzzone
--

CREATE UNIQUE INDEX user_open_id_uindex ON public.users USING btree (open_id);


--
-- Name: address address_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_users_open_id_fk FOREIGN KEY (openid) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: cart cart_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id);


--
-- Name: cart cart_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id);


--
-- Name: comment comment_post_post_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_post_post_id_fk FOREIGN KEY (post_id) REFERENCES public.post(post_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: comment comment_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_users_open_id_fk FOREIGN KEY (from_openid) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: completed_order completed_order_order_order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.completed_order
    ADD CONSTRAINT completed_order_order_order_id_fk FOREIGN KEY (order_id) REFERENCES public.shop_order(order_id);


--
-- Name: completed_order completed_order_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.completed_order
    ADD CONSTRAINT completed_order_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: hot_product hot_product_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.hot_product
    ADD CONSTRAINT hot_product_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: new_product new_product_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.new_product
    ADD CONSTRAINT new_product_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: notification notification_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_users_open_id_fk FOREIGN KEY (from_openid) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: notification notification_users_open_id_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_users_open_id_fk_2 FOREIGN KEY (to_openid) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: shop_order order_address_address_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.shop_order
    ADD CONSTRAINT order_address_address_id_fk FOREIGN KEY (address_id) REFERENCES public.address(address_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: order_item order_item_order_order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT order_item_order_order_id_fk FOREIGN KEY (order_id) REFERENCES public.shop_order(order_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: order_item order_item_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT order_item_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id);


--
-- Name: shop_order order_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.shop_order
    ADD CONSTRAINT order_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: post post_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: product_intro_images product_intro_images_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.product_intro_images
    ADD CONSTRAINT product_intro_images_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: product_simple_images product_simple_images_product_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.product_simple_images
    ADD CONSTRAINT product_simple_images_product_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id);


--
-- Name: records_item records_item_records_records_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.records_item
    ADD CONSTRAINT records_item_records_records_id_fk FOREIGN KEY (records_id) REFERENCES public.records(records_id);


--
-- Name: records records_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT records_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: support support_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.support
    ADD CONSTRAINT support_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: tocomplete_order tocomplete_order_order_order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.tocomplete_order
    ADD CONSTRAINT tocomplete_order_order_order_id_fk FOREIGN KEY (order_id) REFERENCES public.shop_order(order_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: tocomplete_order tocomplete_order_users_open_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: hzzone
--

ALTER TABLE ONLY public.tocomplete_order
    ADD CONSTRAINT tocomplete_order_users_open_id_fk FOREIGN KEY (open_id) REFERENCES public.users(open_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

