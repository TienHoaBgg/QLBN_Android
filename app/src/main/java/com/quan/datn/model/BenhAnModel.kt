package com.quan.datn.model

data class BenhAnModel (
    var id : Int,
    var maBA :String?,
    var canNang : Float?,
    var nhomMau:String?,
    var nhietDo: Float?,
    var mach: Int?,
    var huyetAp: Int?,
    var nhipTho: Int?,
    var lyDoKham:String?,
    var tinhTrangHT:String?,
    var benhSu:String?,
    var chanDoanSoBo:String?,
    var yeuCauThem:String?,
    var chanDoanSauCung:String?,
    var huongDieuTri:String?,
    var thoiGianKham :String?,
    var phongKham : PhongKhamModel?,
    var phongBenh: PhongBenhModel?,
    var donThuoc : MutableList<DonThuocModel>? = arrayListOf()
)
