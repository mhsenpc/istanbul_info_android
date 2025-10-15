# Istanbul Info | اطلاعات استانبول

<div align="center">
  <img src="app/src/main/res/drawable/istanbul_icon_foreground.xml" alt="Istanbul Info Logo" width="120">

  **Istanbul Tourism Guide App**

  A comprehensive Android travel guide for exploring Istanbul's historical attractions

  [![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://android.com)
  [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)
  [![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.oracle.com/java/)
  [![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
</div>

## 📱 About the App | درباره برنامه

Istanbul Info is a comprehensive tourism guide application designed specifically for Persian-speaking tourists visiting Istanbul. The app provides detailed information about 20 of Istanbul's most famous historical attractions, complete with historical context, visiting information, and helpful tips.

**اطلاعات استانبول یک راهنمای جامع گردشگری برای بازدیدکنندگان فارسی‌زبان از استانبول است. این برنامه اطلاعات دقیقی درباره ۲۰ attraction تاریخی مشهور استانبول ارائه می‌دهد.**

## ✨ Features | ویژگی‌ها

### 🏛️ **Historical Attractions | جاذبه‌های تاریخی**
- **20 Major Sites:** Complete coverage of Istanbul's most important landmarks
- **Detailed History:** Rich historical background for each attraction
- **Practical Information:** Visiting hours, addresses, and ticket prices
- **Expert Tips:** Insider advice for better visiting experiences

**۲۰ مکان اصلی:** پوشش کامل مهم‌ترین نقاط استانبول
**تاریخچه دقیق:** پس‌زمینه تاریخی غنی برای هر جاذبه
**اطلاعات عملی:** ساعات بازدید، آدرس‌ها و قیمت بلیط
**نکات متخصص:** توصیه‌های داخلی برای تجربه بهتر بازدید

### 🌍 **Multilingual Support | پشتیبانی چندزبانه**
- **Primary Language:** Persian (Farsi) interface and content
- **Original Names:** English names preserved for reference
- **Cultural Context:** Content adapted for Persian-speaking tourists

**زبان اصلی:** رابط کاربری و محتوای فارسی
**نام‌های اصلی:** نام‌های انگلیسی حفظ شده برای مرجع
**بافت فرهنگی:** محتوا برای گردشگران فارسی‌زبان بهینه شده

### 🔍 **User-Friendly Features | ویژگی‌های کاربرپسند**
- **Search Functionality:** Find attractions quickly and easily
- **Bookmark System:** Save your favorite places
- **Beautiful UI:** Clean, intuitive interface design
- **Offline Ready:** Access content without internet connection

**جستجو:** یافتن سریع و آسان جاذبه‌ها
**نشانکذاری:** ذخیره مکان‌های مورد علاقه
**رابط کاربری زیبا:** طراحی تمیز و شهودی
**آفلاین:** دسترسی به محتوا بدون اتصال اینترنت

## 🏰 Featured Attractions | جاذبه‌های برجسته

### 🕌 **Religious Sites | مکان‌های مذهبی**
- **Hagia Sophia** | ایا صوفیه
- **Blue Mosque** | مسجد آبی (سلطان‌احمد)
- **Suleymaniye Mosque** | مسجد سلیمانیه
- **Ahrida Synagogue** | کنیسه اهریدا

### 👑 **Palaces & Royalty | کاخ‌ها و سلطنت**
- **Topkapi Palace** | کاخ توپکاپی
- **Dolmabahce Palace** | کاخ دلمه باغچه
- **Beylerbeyi Palace** | کاخ بیازیت

### 🏪 **Markets & Commerce | بازارها و تجارت**
- **Grand Bazaar** | بازار بزرگ
- **Egyptian Bazaar** | بازار مصری
- **Istiklal Avenue** | خیابان استقلال

### 🏛️ **Museums & Culture | موزه‌ها و فرهنگ**
- **Turkish and Islamic Arts Museum** | موزه هنرهای ترکیه و اسلامی
- **Hagia Sophia Museum** | موزه ایاصوفیا

### 🌉 **Bridges & Towers | پل‌ها و برج‌ها**
- **Galata Tower** | برج گالاتا
- **Galata Bridge** | پل گالاتا
- **Maiden's Tower** | برج میدان

### 🏞️ **Parks & Fortifications | پارک‌ها و استحکامات**
- **Gulhane Park** | پارک گولهانه
- **Basilica Cistern** | حوض قیصریه
- **Rumeli Fortress** | قلعه روملی حصار
- **Theodosian Walls** | دیوار تئودوسی

## 🛠️ Technical Details | جزئیات فنی

### **Requirements | نیازمندی‌ها**
- **Android Version:** Android 5.0 (API Level 21) or higher
- **Storage:** ~50MB available space
- **Languages:** Persian (Farsi), English (reference)

### **Architecture | معماری**
- **Language:** Java
- **Minimum SDK:** 21
- **Target SDK:** 34
- **Architecture Pattern:** MVC (Model-View-Controller)

### **Key Components | اجزای کلیدی**
- **PlaceData.java:** Central data management for attractions
- **MainActivity.java:** Main navigation and entry point
- **SearchActivity.java:** Advanced search functionality
- **BookmarksActivity.java:** User favorites management

## 📸 Screenshots | اسکرین‌شات‌ها

*(Note: Add actual screenshots when available)*

```
[Main Screen]     [Attraction Detail]     [Search Screen]     [Bookmarks]
```

## 🚀 Getting Started | شروع کار

### **Prerequisites | پیش‌نیازها**
1. **Android Studio:** Latest stable version
2. **JDK:** Java Development Kit 8 or higher
3. **Android SDK:** API Level 21+

### **Installation | نصب**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/istanbul-info.git
   cd istanbul-info
   ```

2. Open in Android Studio:
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. Build and run:
   - Connect Android device or start emulator
   - Click "Run" button or press `Ctrl+R`

## 📂 Project Structure | ساختار پروژه

```
app/
├── src/main/
│   ├── java/sibpardazan/gharb/istanbulinfo/
│   │   ├── MainActivity.java          # Main activity
│   │   ├── SearchActivity.java        # Search functionality
│   │   ├── BookmarksActivity.java     # Bookmarks management
│   │   ├── AboutActivity.java         # About screen
│   │   ├── ReferencesActivity.java    # References and sources
│   │   └── PlaceData.java             # Data model and management
│   ├── res/
│   │   ├── layout/                    # XML layout files
│   │   ├── values/
│   │   │   ├── strings.xml           # App strings (Persian)
│   │   │   ├── colors.xml            # Color scheme
│   │   │   └── styles.xml            # App themes
│   │   ├── drawable/                 # Icons and graphics
│   │   └── mipmap-*/                 # App icons for different densities
│   └── AndroidManifest.xml           # App manifest
└── build.gradle                      # App-level build configuration
```

## 🎨 Design System | سیستم طراحی

### **Color Palette | پالت رنگ**
- **Primary Blue:** `#1E3A8A` (Istanbul blue)
- **Secondary Red:** `#DC2626` (Turkish red)
- **Accent Gold:** `#FCD34D` (Ottoman gold)
- **Success Green:** `#10B981` (Nature/gardens)
- **Error Red:** `#EF4444` (Location pins)

### **Typography | تایپوگرافی**
- **Primary:** Sans-serif fonts for readability
- **Persian Support:** Optimized for Persian text rendering
- **Hierarchy:** Clear distinction between titles and content

## 🌍 Localization | بومی‌سازی

### **Persian Language | زبان فارسی**
- **RTL Support:** Right-to-left layout support
- **Persian Content:** All content translated to native Persian
- **Cultural Adaptation:** Content adapted for Persian-speaking tourists

### **English Reference | مرجع انگلیسی**
- **Original Names:** English names preserved for reference
- **Universal Understanding:** Helps with international recognition

## 🔧 Customization | سفارشی‌سازی

### **Adding New Attractions | افزودن جاذبه جدید**
1. Update `PlaceData.java`:
   ```java
   // Add new case in getPlace() method
   case NEW_INDEX:
       return new PlaceContent(
           context.getString(R.string.new_place),
           context.getString(R.string.new_place_history),
           // ... other parameters
       );
   ```

2. Add strings in `strings.xml`:
   ```xml
   <string name="new_place">نام فارسی</string>
   <string name="new_place_history">تاریخچه...</string>
   <!-- Add other strings -->
   ```

3. Update `getAllPlaceNames()` method

### **Modifying Colors | تغییر رنگ‌ها**
Edit `colors.xml` to customize the app theme:
```xml
<color name="primary_blue">#1E3A8A</color>
<color name="accent_red">#DC2626</color>
<!-- Customize other colors -->
```

## 🤝 Contributing | مشارکت

Contributions are welcome! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch:
   ```bash
   git checkout -b feature/new-feature
   ```
3. **Commit** your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4. **Push** to the branch:
   ```bash
   git push origin feature/new-feature
   ```
5. **Create** a Pull Request

### **Contribution Guidelines | راهنمای مشارکت**
- Follow existing code style and conventions
- Add comments for complex code sections
- Test thoroughly before submitting
- Update documentation as needed

## 📄 License | مجوز

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### **About the Developer | درباره توسعه‌دهنده**
This app was developed with the goal of helping Persian-speaking tourists explore Istanbul's rich historical heritage. All content is provided in Persian to make the experience more accessible and enjoyable for visitors from Iran, Afghanistan, and other Persian-speaking regions.

## 🙏 Acknowledgments | قدردانی

- **Historical Sources:** Various historical and cultural references
- **Android Documentation:** Android Developer Guides
- **Open Source Community:** Libraries and tools that made this project possible

## 📞 Support & Contact | پشتیبانی و تماس

For support, suggestions, or bug reports:

- **Email:** mhsenpc@gmail.com
- **Issues:** [GitHub Issues](https://github.com/yourusername/istanbul-info/issues)

### **Feedback | بازخورد**
Your feedback helps improve this app! Please share your experience, suggestions, or report any issues via email or GitHub Issues.

---

<div align="center">
  <sub>Made with ❤️ for tourists exploring Istanbul's beauty</sub>
  <br>
  <sub>ساخته شده با ❤️ برای گردشگرانی که در حال کاوش زیبایی‌های استانبول هستند</sub>
</div>