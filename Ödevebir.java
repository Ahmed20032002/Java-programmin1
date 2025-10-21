
class Stok {
	

    private String urunAdi;         // اسم المنتج
    private int gelenAdet;          // عدد القطع التي وصلت
    private int satilanAdet;        // عدد القطع المباعة
    private double alisFiyati;      // سعر الشراء
    private double satisFiyati;     // سعر البيع

    // المُنشئ (Constructor)
    public Stok(String urunAdi, double alisFiyati, double satisFiyati) {
        this.urunAdi = urunAdi;
        this.alisFiyati = alisFiyati;
        this.satisFiyati = satisFiyati;
        this.gelenAdet = 0;
        this.satilanAdet = 0;
    }

    // إضافة بضائع إلى المخزون
    public void malGeldi(int adet) {
        gelenAdet += adet;
        System.out.println(adet + " من " + urunAdi + " أُضيفت إلى المخزون.");
    }

    // بيع منتجات من المخزون
    public void malSatildi(int adet) {
        if (adet > getStokAdedi()) {
            System.out.println("❌ المخزون غير كافٍ! الكمية المتاحة: " + getStokAdedi());
        } else {
            satilanAdet += adet;
            System.out.println(adet + " من " + urunAdi + " تم بيعها.");
        }
    }

    // حساب عدد القطع المتبقية في المخزون
    public int getStokAdedi() {
        return gelenAdet - satilanAdet;
    }

    // حساب تكلفة الشراء الإجمالية
    public double getToplamAlis() {
        return gelenAdet * alisFiyati;
    }

    // حساب إجمالي المبيعات
    public double getToplamSatis() {
        return satilanAdet * satisFiyati;
    }

    // حساب الربح لوحدة واحدة
    public double getTekUrunKari() {
        return satisFiyati - alisFiyati;
    }

    // حساب نسبة الربح المئوية
    public double getKarOrani() {
        if (alisFiyati == 0) return 0;
        return (getTekUrunKari() / alisFiyati) * 100;
    } 

    // طباعة كل المعلومات عن المنتج
    public void urunBilgileri() {
        System.out.println("\n--- معلومات المنتج ---");
        System.out.println("اسم المنتج: " + urunAdi);
        System.out.println("سعر الشراء: " + alisFiyati + " ليرة");
        System.out.println("سعر البيع: " + satisFiyati + " ليرة");
        System.out.println("إجمالي القطع الواردة: " + gelenAdet);
        System.out.println("إجمالي القطع المباعة: " + satilanAdet);
        System.out.println("المخزون الحالي: " + getStokAdedi());
        System.out.println("الربح لكل وحدة: " + getTekUrunKari() + " ليرة");
        System.out.println("نسبة الربح: %" + String.format("%.2f", getKarOrani()));
        System.out.println("إجمالي تكلفة الشراء: " + getToplamAlis() + " ليرة");
        System.out.println("إجمالي المبيعات: " + getToplamSatis() + " ليرة");
    }
}

// البرنامج الرئيسي
public class Ödevebir {
    public static void main(String[] args) {
        // إنشاء كائن من الفئة Stok
        Stok urun1 = new Stok("حليب", 10.0, 15.0);

        urun1.malGeldi(100);   // وصول 100 قطعة
        urun1.malSatildi(30);  // بيع 30 قطعة
        urun1.urunBilgileri(); // عرض معلومات المنتج
    }
}
