package com.example.lql.kotlindemo.http.retrofitUtils;


import com.example.lql.kotlindemo.bean.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/21
 * 修改备注：
 */
public interface RetrofitApi {

    /**
     * rxjava+retrofit
     *
     * @param start
     * @param count
     * @return
     */
    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);



    /**
     * get请求
     *
     * @return
     */
    @GET("/")
    Call<String> getBaidu();


    /**
     * post上传参数带文件
     */


//    这里@MultiPart的意思就是允许多个@Part了，我们这里使用了3个@Part，第一个我们准备上传个文件，使用了MultipartBody.Part类型，其余两个均为简单的键值对。
//    @Multipart
//    @POST("register")
//    Call<User> registerUser(@Part MultipartBody.Part photo, @Part("username") RequestBody username, @Part("password") RequestBody password);

    /**
     *  说一下post请求和get请求的方法
     *  先说两个请求的方式，get方式是为了请求数据，post方式是为了给后台提交数据
     *  所以在get请求的时候，传递参数的时候使用@Query()关键字，
     *  而在post请求的时候应该使用@Field()关键字，这里需要注意，在post的请求使用@Field()关键字的时候，一定要在@POST下边加上 @FormUrlEncoded
     *
     *
     *  现在，可能有人会说，那就是还有使用post请求的时候还有可能不适用@Field()关键字呗
     *  是的，在post请求中，也可以使用@Query()关键字，这样也能请求到数据，这时候用不需要再@POST下边加上 @FormUrlEncoded
     *  也就是说 @FormUrlEncoded  和@Field() 是同时出现的
     *
     *  现在发现了一种情况啊，在post请求中，如果请求的url没有入参，这时候就不用@FormUrlEncoded
     *
     */


//    方法注解，包含@GET、@POST、@PUT、@DELETE、@PATH、@HEAD、@OPTIONS、@HTTP。
//    标记注解，包含@FormUrlEncoded、@Multipart、@Streaming。
//    参数注解，包含@Query,@QueryMap、@Body、@Field，@FieldMap、@Part，@PartMap。
//    其他注解，@Path、@Header,@Headers、@Url


//==========================================================================================标记注解==========================================================================================
//    @FormUrlEncoded、@Multipart、@Streaming。
    /**
     *  FormUrlEncoded注解:
     *
     * 用于修饰Field注解和FieldMap注解
     * 使用该注解,表示请求正文将使用表单网址编码。字段应该声明为参数，
     * 并用@Field注释或FieldMap注释。使用FormUrlEncoded注解的请求将具”application / x-www-form-urlencoded”
     * MIME类型。字段名称和值将先进行UTF-8进行编码,再根据RFC-3986进行URI编码.
     */


    /**
     * @Multipart注解:
     * 用于修饰@Part和@PartMap 用于文件的上传
     * 使用该注解,表示请求体是多部分的。 每一部分作为一个参数,且用Part注解声明
     */

    /**
     * @Streaming：
     * 作用于方法
     * 一般用于文件的下载
     * 处理返回Response的方法的响应体，即没有将body（）转换为byte []。
     */


//==========================================================================================参数注解==========================================================================================

//    @Query,@QueryMap、@Body、@Field，@FieldMap、@Part，@PartMap。

    /**
     * @Query注解:
     * 作用于方法的参数
     * 用于添加查询参数,即请求参数
     * 参数值通过String.valueOf()转换为String并进行URL编码
     * 使用该注解定义的参数,参数值可以为空,为空时,忽略该值,当传入一个List或array时,为每个非空item拼接请求键值对,所有的键是统一的,如: name=张三&name=李四&name=王五.
     * @GET("/list")
     * Call<ResponseBody> list(@Query("page") int page);
     * @GET("/list")
     * Call<ResponseBody> list(@Query("category") String category);
     * //传入一个数组
     * @GET("/list")
     * Call<ResponseBody> list(@Query("category") String... categories);
     * //不进行URL编码
     * @GET("/search")
     * Call<ResponseBody> list(@Query(value="foo", encoded=true) String foo);
     */

    /**
     * @QueryMap注解
     * 作用于方法的参数
     * 以map的形式添加查询参数,即请求参数
     * 参数值通过String.valueOf()转换为String并进行URL编码
     * map的键和值默认进行URL编码
     * map中每一项的键和值都不能为空,否则抛出IllegalArgumentException异常
     * //使用默认URL编码
     * @GET("/search")
     * Call<ResponseBody> list(@QueryMap Map<String, String> filters);
     * //不使用默认URL编码
     * @GET("/search")
     * Call<ResponseBody> list(@QueryMap(encoded=true) Map<String, String> filters);
     */


    /**
     * @Body
     * 作用于方法的参数
     * 使用该注解定义的参数不可为null
     * 当你发送一个post或put请求,但是又不想作为请求参数或表单的方式发送请求时,使用该注解定义的参数可以直接传入一个实体类,retrofit会通过convert把该实体序列化并将序列化后的结果直接作为请求体发送出去.
     *  @POST("/")
     *  Call<ResponseBody> sendNormal(@Body TestBean repo);
     */

    /**
     * @Field
     * 作用于方法的参数
     * 用于发送一个表单请求@Post
     * 用String.valueOf()把参数值转换为String,然后进行URL编码,当参数值为null值时,会自动忽略,
     * 如果传入的是一个List或array,则为每一个非空的item拼接一个键值对,每一个键值对中的键是相同的,值就是非空item的值,
     * 如: name=张三&name=李四&name=王五,另外,如果item的值有空格,在拼接时会自动忽略,例如某个item的值为:张 三,则拼接后为name=张三.
     *
     *
     *
     *
     * //普通参数
     * @FormUrlEncoded
     * @POST("/")
     * Call<ResponseBody> example(@Field("name") String name,@Field("occupation") String occupation);
     *
     * //固定或可变数组
     * @FormUrlEncoded
     * @POST("/list")
     * Call<ResponseBody> example(@Field("name") String... names);
     */


    /**
     * @FieldMap
     * 作用于方法的参数
     * 用于发送一个表单请求
     * map中每一项的键和值都不能为空,否则抛出IllegalArgumentException异常
     * @FormUrlEncoded
     * @POST("/things")
     * Call<ResponseBody> things(@FieldMap Map<String, String> fields);
     */


    /**
     *  @Part，@PartMap：用于POST文件上传
     *
     * 其中@Part MultipartBody.Part代表文件，@Part("key") RequestBody代表参数
     * 需要添加@Multipart表示支持文件上传的表单，Content-Type: multipart/form-data
     * 当函数有@Multipart注解的时候，将会发送multipart数据，Parts都使用@Part注解进行声明
     * Multipart parts要使用Retrofit的众多转换器之一或者实现RequestBody来处理自己的序列化
     *
     *
     * @Multipart
     * @POST("/")
     * Call<ResponseBody> example(
     * @Part("description") String description,
     * @Part(value = "image", encoding = "8-bit") RequestBody image);
     *
     *
     * @Multipart
     * @POST("/upload")
     * Call<ResponseBody> upload(
     * @Part("file") RequestBody file,
     * @PartMap Map<String, RequestBody> params);
     */


//==========================================================================================其他注解==========================================================================================
//    @Path、@Header,@Headers、@Url
    /**
     * @Path()
     * 在一个后台接口方法中，有一个方法名称是
     * usercenter/UserFavoriteList
     * 另一个方法名称是
     * NewUsercenter/UserFavoriteList
     * 这个如果分开写，就是这样的：
     *
     *     @POST("usercenter/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     *     @POST("NewUsercenter/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     * 会发现两个分浪费，有点冗余。所以用path关键字，这样写：
     *
     *    @POST("{name}/UserFavoriteList")
     *     Call<UserFavoriteListBeanForRetrofit> UserFavoriteList(@Path(name) String ClassNme,@Query("Userid") String Userid, @Query("type") String type, @Query("page") String page, @Query("rows") String rows);
     *
     * 然后在使用的时候，就把方法名在第一个参数里边传进来
     *
     */


    /**
     * @Header
     * 作用于方法的参数, 用于添加请求头
     * 使用该注解定义的请求头可以为空,当为空时,会自动忽略,当传入一个List或array时,为拼接每个非空的item的值到请求头中.
     * 具有相同名称的请求头不会相互覆盖,而是会照样添加到请求头中
     * //添加一个请求头
     * @Headers("Cache-Control: max-age=640000")
     * @GET("/") ...
     */


    /**
     * @Headers
     * 作用于方法, 用于添加一个或多个请求头
     * 具有相同名称的请求头不会相互覆盖,而是会照样添加到请求头中
     * //添加多个请求头
     * @Headers({ "X-Foo: Bar",
     * "X-Ping: Pong"
     * })
     * @GET("/") ...
     */


    /**
     * @Url
     * 作用于方法参数
     * 用于添加请求的接口地址
     * @GET
     * Call<ResponseBody> list(@Url String url);
     */
}
