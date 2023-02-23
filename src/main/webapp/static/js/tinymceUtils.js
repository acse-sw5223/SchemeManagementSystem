var tinyMce = {
    init: function (id) {
        tinymce.init({
            selector: '#' + id,
            language:'zh_CN',
            height: 550,
            min_height: 500,
            max_height: 700,
            images_upload_url: 'file?method=upload',
            content_style: "img {max-width:100%;}",
            plugins: 'print preview axupimgs searchreplace autolink directionality visualblocks visualchars fullscreen image link media template code codesample table charmap hr pagebreak nonbreaking anchor insertdatetime advlist lists wordcount imagetools textpattern help emoticons autosave bdmap indent2em autoresize formatpainter axupimgs',
            toolbar: 'undo redo restoredraft image axupimgs | styleselect formatselect fontselect fontsizeselect  | forecolor backcolor bold italic  bullist numlist | ' +
                'alignleft aligncenter alignright alignjustify outdent indent | ' +
                'copy paste pastetext underline strikethrough | blockquote subscript superscript removeformat |' +
                ' table  media charmap emoticons hr pagebreak insertdatetime print preview | fullscreen | bdmap indent2em lineheight formatpainter axupimgs | link anchor code',
            fontsize_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',
            font_formats: '微软雅黑=Microsoft YaHei,Helvetica Neue,PingFang SC,sans-serif;苹果苹方=PingFang SC,Microsoft YaHei,sans-serif;宋体=simsun,serif;仿宋体=FangSong,serif;黑体=SimHei,sans-serif;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;',
            link_list: [
                { title: '预置链接1', value: 'http://www.tinymce.com' },
                { title: '预置链接2', value: 'http://tinymce.ax-z.cn' }
            ],
            image_list: [
                { title: '预置图片1', value: 'https://www.tiny.cloud/images/glyph-tinymce@2x.png' },
                { title: '预置图片2', value: 'https://www.baidu.com/img/bd_logo1.png' }
            ],
            image_class_list: [
                { title: 'None', value: '' },
                { title: 'Some class', value: 'class-name' }
            ],
            importcss_append: true,
            //自定义文件选择器的回调内容
            file_picker_callback: function (callback, value, meta) {
                if (meta.filetype === 'file') {
                    callback('https://www.baidu.com/img/bd_logo1.png', { text: 'My text' });
                }
                if (meta.filetype === 'image') {
                    callback('https://www.baidu.com/img/bd_logo1.png', { alt: 'My alt text' });
                }
                if (meta.filetype === 'media') {
                    callback('movie.mp4', { source2: 'alt.ogg', poster: 'https://www.baidu.com/img/bd_logo1.png' });
                }
            },
            toolbar_sticky: true,
            autosave_ask_before_unload: false,
            images_upload_handler: function (blobInfo, succFun, failFun) {
                var xhr, formData;
                var file = blobInfo.blob();//转化为易于理解的file对象
                xhr = new XMLHttpRequest();
                xhr.withCredentials = false;
                xhr.open('POST', 'file?method=upload');
                xhr.onload = function() {
                    var json;
                    if (xhr.status != 200) {
                        failFun('HTTP Error: ' + xhr.status);
                        return;
                    }
                    json = JSON.parse(xhr.responseText);
                    if (!json || typeof json.location != 'string') {
                        failFun('Invalid JSON: ' + xhr.responseText);
                        return;
                    }
                    succFun(json.location);
                };
                formData = new FormData();
                formData.append('file', file, file.name );
                xhr.send(formData);
            }
        });
    }
}