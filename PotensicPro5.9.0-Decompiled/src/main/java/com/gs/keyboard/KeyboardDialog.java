package com.gs.keyboard;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.gs.keyboard.databinding.DialogKeyboardBinding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes2.dex */
public class KeyboardDialog extends Dialog implements KeyboardView.OnKeyboardActionListener {
    private static final int ORDER_LETTER = 2;
    private static final int ORDER_NUMBER = 0;
    private static final int ORDER_SYMBOL = 1;
    private KeyboardAttribute attribute;
    private boolean isNumberRandom;
    private boolean isUpper;
    private DialogKeyboardBinding mBinding;
    private int mCurrentOrder;
    private Keyboard mLetterKeyboard;
    private Keyboard mNumberKeyboard;
    private ArrayList<String> mNumberPool;
    private SparseArray<Keyboard> mOrderToKeyboard;
    private ColorStateList mSelectedTextColor;
    private Keyboard mSymbolKeyboard;
    private WeakReference<SecurityEditText> mTargetEditText;
    private ColorStateList mUnSelectedTextColor;

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }

    public KeyboardDialog(Context context, SecurityEditText securityEditText) {
        super(context, R.style.NoFrameDialog);
        this.mSelectedTextColor = ColorStateList.valueOf(-16776961);
        this.mUnSelectedTextColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.isNumberRandom = true;
        this.isUpper = false;
        this.mOrderToKeyboard = new SparseArray<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mNumberPool = arrayList;
        arrayList.add("48#0");
        this.mNumberPool.add("49#1");
        this.mNumberPool.add("50#2");
        this.mNumberPool.add("51#3");
        this.mNumberPool.add("52#4");
        this.mNumberPool.add("53#5");
        this.mNumberPool.add("54#6");
        this.mNumberPool.add("55#7");
        this.mNumberPool.add("56#8");
        this.mNumberPool.add("57#9");
        this.mTargetEditText = new WeakReference<>(securityEditText);
    }

    public static KeyboardDialog show(Context context, SecurityEditText securityEditText) {
        KeyboardDialog keyboardDialog = new KeyboardDialog(context, securityEditText);
        keyboardDialog.show();
        return keyboardDialog;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogKeyboardBinding inflate = DialogKeyboardBinding.inflate(LayoutInflater.from(getContext()));
        this.mBinding = inflate;
        setContentView(inflate.getRoot());
        initAttribute();
        initKeyboards();
        initKeyboardChooser();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.flags = 8;
            setCanceledOnTouchOutside(false);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.KeyboardDialogAnimation);
        }
    }

    private void initAttribute() {
        this.attribute = this.mTargetEditText.get().getKeyboardAttribute();
    }

    private void initKeyboards() {
        if (this.attribute.keyboardBackground != null) {
            this.mBinding.keyboardView.setBackground(this.attribute.keyboardBackground);
        }
        if (this.attribute.chooserBackground != null) {
            this.mBinding.keyboardChooser.setBackground(this.attribute.chooserBackground);
        }
        if (this.attribute.chooserSelectedColor != null) {
            this.mSelectedTextColor = this.attribute.chooserSelectedColor;
        }
        if (this.attribute.chooserUnselectedColor != null) {
            this.mUnSelectedTextColor = this.attribute.chooserUnselectedColor;
        }
        if (this.attribute.isKeyPreview) {
            this.mBinding.keyboardView.setPreviewEnabled(true);
        } else {
            this.mBinding.keyboardView.setPreviewEnabled(false);
        }
        this.mBinding.keyboardView.setOnKeyboardActionListener(this);
        if (isPortrait()) {
            this.mLetterKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_english);
            this.mSymbolKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_symbols_shift);
            this.mNumberKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_number);
        } else {
            this.mLetterKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_english_land);
            this.mSymbolKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_symbols_shift_land);
            this.mNumberKeyboard = new Keyboard(getContext(), R.xml.gs_keyboard_number_land);
        }
        if (this.isNumberRandom) {
            randomNumbers();
        }
        this.mOrderToKeyboard.put(0, this.mNumberKeyboard);
        this.mOrderToKeyboard.put(1, this.mSymbolKeyboard);
        this.mOrderToKeyboard.put(2, this.mLetterKeyboard);
        this.mCurrentOrder = 2;
        onCurrentKeyboardChange();
    }

    private void initKeyboardChooser() {
        this.mBinding.tvNumber.setOnClickListener(new View.OnClickListener() { // from class: com.gs.keyboard.-$$Lambda$KeyboardDialog$inpAEe_K0uWlODSlYj848C7Kdz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardDialog.this.lambda$initKeyboardChooser$0$KeyboardDialog(view);
            }
        });
        this.mBinding.tvSymbol.setOnClickListener(new View.OnClickListener() { // from class: com.gs.keyboard.-$$Lambda$KeyboardDialog$yoPL7N2k3lDh3GT03qjHuwqpCwU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardDialog.this.lambda$initKeyboardChooser$1$KeyboardDialog(view);
            }
        });
        this.mBinding.tvLetter.setOnClickListener(new View.OnClickListener() { // from class: com.gs.keyboard.-$$Lambda$KeyboardDialog$SdduKDsDahd2IkNRIwDtkygpy0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardDialog.this.lambda$initKeyboardChooser$2$KeyboardDialog(view);
            }
        });
    }

    public /* synthetic */ void lambda$initKeyboardChooser$0$KeyboardDialog(View view) {
        this.mCurrentOrder = 0;
        onCurrentKeyboardChange();
    }

    public /* synthetic */ void lambda$initKeyboardChooser$1$KeyboardDialog(View view) {
        this.mCurrentOrder = 1;
        onCurrentKeyboardChange();
    }

    public /* synthetic */ void lambda$initKeyboardChooser$2$KeyboardDialog(View view) {
        this.mCurrentOrder = 2;
        onCurrentKeyboardChange();
    }

    private void onCurrentKeyboardChange() {
        if (this.mCurrentOrder == 0 && this.isNumberRandom) {
            randomNumbers();
        }
        this.mBinding.keyboardView.setKeyboard(this.mOrderToKeyboard.get(this.mCurrentOrder));
        int i = this.mCurrentOrder;
        if (i == 0) {
            this.mBinding.tvNumber.setTextColor(this.mSelectedTextColor);
            this.mBinding.tvSymbol.setTextColor(this.mUnSelectedTextColor);
            this.mBinding.tvLetter.setTextColor(this.mUnSelectedTextColor);
        } else if (i == 1) {
            this.mBinding.tvNumber.setTextColor(this.mUnSelectedTextColor);
            this.mBinding.tvSymbol.setTextColor(this.mSelectedTextColor);
            this.mBinding.tvLetter.setTextColor(this.mUnSelectedTextColor);
        } else {
            if (i == 2) {
                this.mBinding.tvNumber.setTextColor(this.mUnSelectedTextColor);
                this.mBinding.tvSymbol.setTextColor(this.mUnSelectedTextColor);
                this.mBinding.tvLetter.setTextColor(this.mSelectedTextColor);
                return;
            }
            throw new IllegalStateException(getContext().getString(R.string.exception_invalid_keyboard));
        }
    }

    private boolean isPortrait() {
        return getContext().getResources().getConfiguration().orientation == 1;
    }

    private void randomNumbers() {
        if (this.mNumberKeyboard != null) {
            ArrayList arrayList = new ArrayList(this.mNumberPool);
            for (Keyboard.Key key : this.mNumberKeyboard.getKeys()) {
                if (key.label != null && isNumber(key.label.toString())) {
                    int nextInt = new Random().nextInt(arrayList.size());
                    String[] split = ((String) arrayList.get(nextInt)).split("#");
                    key.label = split[1];
                    key.codes[0] = Integer.valueOf(split[0], 10).intValue();
                    arrayList.remove(nextInt);
                }
            }
        }
    }

    private boolean isNumber(String str) {
        return getContext().getString(R.string.zeroToNine).contains(str.toLowerCase());
    }

    private void changeKey() {
        Keyboard keyboard = this.mLetterKeyboard;
        if (keyboard != null) {
            List<Keyboard.Key> keys = keyboard.getKeys();
            if (this.isUpper) {
                this.isUpper = false;
                for (Keyboard.Key key : keys) {
                    if (key.label != null && isLetter(key.label.toString())) {
                        key.label = key.label.toString().toLowerCase();
                        key.codes[0] = key.codes[0] + 32;
                    }
                    if (key.codes[0] == -1) {
                        key.icon = getContext().getResources().getDrawable(R.drawable.keyboard_shift);
                    }
                }
                return;
            }
            this.isUpper = true;
            for (Keyboard.Key key2 : keys) {
                if (key2.label != null && isLetter(key2.label.toString())) {
                    key2.label = key2.label.toString().toUpperCase();
                    key2.codes[0] = key2.codes[0] - 32;
                }
                if (key2.codes[0] == -1) {
                    key2.icon = getContext().getResources().getDrawable(R.drawable.keyboard_shift_c);
                }
            }
        }
    }

    private boolean isLetter(String str) {
        return getContext().getString(R.string.aToz).contains(str.toLowerCase());
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int i, int[] iArr) {
        Editable text = this.mTargetEditText.get().getText();
        int selectionStart = this.mTargetEditText.get().getSelectionStart();
        if (i == -3) {
            hideKeyboard();
            return;
        }
        if (i == -5) {
            if (text == null || text.length() <= 0 || selectionStart <= 0) {
                return;
            }
            text.delete(selectionStart - 1, selectionStart);
            return;
        }
        if (i == -1) {
            changeKey();
            this.mCurrentOrder = 2;
            onCurrentKeyboardChange();
            return;
        }
        text.insert(selectionStart, Character.toString((char) i));
    }

    private void hideKeyboard() {
        dismiss();
    }
}
