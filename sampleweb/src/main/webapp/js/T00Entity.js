$(function() {

    $('#RegistT00Entity').on('click', function() {

        let suryoQt = $('[name="T00Entity.suryoQt"]').val();

        let juchuPr = $('[name="T00Entity.juchuPr"]').val();
        let juchuAm = suryoQt * juchuPr;
        $('[id="T00Entity.juchuAm"]').html(juchuAm);
        $('[name="T00Entity.juchuAm"]').val(juchuAm);

        let hachuPr = $('[name="T00Entity.hachuPr"]').val();
        let hachuAm = suryoQt * hachuPr;
        $('[id="T00Entity.hachuAm"]').html(hachuAm);
        $('[name="T00Entity.hachuAm"]').val(hachuAm);
    });
});
