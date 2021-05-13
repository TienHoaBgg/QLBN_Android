package com.quan.datn.ui.home

import android.widget.TextView
import com.app.feng.fixtablelayout.inter.IDataAdapter
import com.quan.datn.model.BenhAnModel


class HomeAdapter : IDataAdapter {

    var dsBenhAn: MutableList<BenhAnModel> = arrayListOf()
    var titles:Array<String> = arrayOf("Mã BA","Lý do khám","Tình trạng hiện tại","Chẩn đoán sơ bộ",
        "Yêu cầu thêm","Chẩn đoán sau cùng","Hướng điều trị","Mạch","Huyết áp")

    constructor(data: MutableList<BenhAnModel>){
        this.dsBenhAn = data
    }

    override fun getTitleAt(pos: Int): String {
        return titles[pos]
    }

    override fun getTitleCount(): Int {
        return titles.size
    }

    override fun getItemCount(): Int {
        return dsBenhAn.size
    }

    override fun convertData(position: Int, bindViews: List<TextView>) {
        val dataBean: BenhAnModel = dsBenhAn[position]
        bindViews[0].text = dataBean.id.toString()
        bindViews[1].text = dataBean.maBA
        bindViews[2].text = dataBean.lyDoKham
        bindViews[3].text = dataBean.tinhTrangHT
        bindViews[4].text = dataBean.chanDoanSoBo
        bindViews[5].text = dataBean.yeuCauThem
        bindViews[6].text = dataBean.chanDoanSauCung
        bindViews[7].text = dataBean.huongDieuTri
    }
//    var maBA :String?,
//    var thoiGianKhammaBA :String?,
//    var canNangmaBA : Float?,
//    var nhomMau:String?,
//    var nhietDo: Float?,
//    var mach: Int?,
//    var huyetAp: Int?,
//    var nhipTho: Int?,
//    var lyDoKham:String?,
//    var tinhTrangHT:String?,
//    var benhSu:String?,
//    var chanDoanSoBo:String?,
//    var yeuCauThem:String?,
//    var chanDoanSauCung:String?,
//    var huongDieuTri:String?,
//    var phongKham : PhongKhamModel?,
//    var phongBenh: PhongBenhModel?,
//    var donThuoc : MutableList<DonThuocModel>? = arrayListOf()
    override fun convertLeftData(position: Int, bindView: TextView) {
//    bindView.text = dsBenhAn[position].id.toString()
    }
}