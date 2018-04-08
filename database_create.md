* user
user_name <open_id> session_key user_img<!--  birthday phone_number sex city province language country -->

* order
user_id time <order_id>

* tocomplete_order
<order_id>

* completed_order
<order_id>

* order_item

<order_id product_id> price counts

* cart
<user_id product_id> counts

* product

<product_id> product_name price

* hot_product
<product_id>

* new_product
<product_id>


* product_intro_images
<product_id url>

* product_simple_images
<product_id url>

* hot_keywords

<id> keywords

* notification

<notification_id> from_openid to_openid content

* post
<post_id> post_time content title open_id 

* comment
<comment_id> post_id from_openid to_openid content comment_time

* support
<support_id open_id>

* records
<records_id> open_id type records_time 

* records_item
records_id item_type item_info

{
	avatarUrl: "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ40OxuL7aV0csyVfrgApStaaxicg9Zs0p7YalHuevLkuWfxjTibZ0SbB6LPVKJcCKDuZWVatbSxwyg/0"
	city: "Chengdu",
	country: "China",
	gender: 1,
	language: "zh_CN",
	nickName: ".",
	province: "Sichuan"
}

