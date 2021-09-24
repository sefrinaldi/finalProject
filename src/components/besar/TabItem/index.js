import React from 'react'
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import {
    IconInbox,
    IconInboxActive
} from '../../../assets';
import { colors } from '../../../utils';

const TabItem = ({ isFocused, onPress, onLongPress, label }) => {

    const Icon = () => {
        if (label === "Inbox") {
            return isFocused ? <IconInboxActive /> : <IconInbox />
        } else
            return <IconInbox />
    }

    return (
        <TouchableOpacity
            onPress={onPress}
            onLongPress={onLongPress}
            style={styles.tabItem}
        >
            {/* <IconInboxActive /> */}
            <Text style={{ color: isFocused ? '#673ab7' : '#222' }}>
                {label}
            </Text>
        </TouchableOpacity>
    )
}

export default TabItem

const styles = StyleSheet.create({
    tabItem: {
        alignItems: 'center'
    }
})
